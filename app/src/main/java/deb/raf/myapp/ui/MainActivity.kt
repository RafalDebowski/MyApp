package deb.raf.myapp.ui

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.facebook.*
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.google.android.gms.auth.api.signin.*
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.*
import dagger.android.AndroidInjection
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import deb.raf.myapp.R
import deb.raf.myapp.ViewModel.AuthViewModel
import deb.raf.myapp.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), HasAndroidInjector {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var callbackManager: CallbackManager
    private lateinit var facebookloginbutton: LoginButton
    private lateinit var googleSignInButton: SignInButton
    private lateinit var googleSignInClient: GoogleSignInClient

    @Inject
    lateinit var authViewModel: AuthViewModel


    private val RC_SIGN_IN = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAuth = FirebaseAuth.getInstance()
        callbackManager = CallbackManager.Factory.create()


        initSignInButton()
        initAuthViewModel()
        initGoogleSignInClient()
        initFacebookSignInButton()

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        callbackManager.onActivityResult(requestCode, resultCode, data)


        if (requestCode == RC_SIGN_IN) {
            var task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                var signInAccount = task.getResult(ApiException::class.java)
                if (signInAccount != null) {
                    getGoogleAuthCredential(signInAccount)
                }
            } catch (e: ApiException) {
                Log.e("Exception", e.message.toString())
            }
        }
    }

    private fun getGoogleAuthCredential(googleSignInAccount: GoogleSignInAccount) {
        var googleTokenId = googleSignInAccount.idToken
        var googleAuthCredential = GoogleAuthProvider.getCredential(googleTokenId, null)
        signInWithGoogleAuthCredential(googleAuthCredential)
    }

    private fun getFacebookAuthCredential(accessToken: AccessToken) {
        signInWithFacebookAuthCredential(accessToken)
    }


    private fun signInWithGoogleAuthCredential(googleAuthCredential: AuthCredential) {
        authViewModel.signInWithGoogle(googleAuthCredential)
        authViewModel.authenticatedUserLiveData.observe(this, { authentificatedUser ->
            if (authentificatedUser.isNew == true) {
                CoroutineScope(Dispatchers.IO).async {
                    createNewUser(authentificatedUser)
                }
            } else {
                goToSignedActivity(authentificatedUser)
            }
        })
    }

    private fun signInWithFacebookAuthCredential(accessToken: AccessToken) {
        authViewModel.signInWithFacebook(accessToken)
        authViewModel.authenticatedUserLiveData.observe(this, { authentificatedUser ->
            if (authentificatedUser.isNew == true) {
                CoroutineScope(Dispatchers.IO).async {
                    createNewUser(authentificatedUser)
                }
            } else {
                goToSignedActivity(authentificatedUser)
            }
        })
    }


    private fun createNewUser(authentificatedUser: User) {
        authViewModel.createUser(authentificatedUser)
        authViewModel.createdUserLiveData.observe(this, { user ->
            if (user.isCreated == true) {
                Log.d("isCreatedSuccess", user.name)
            } else {
                goToSignedActivity(user)
            }
        })
    }


    private fun initGoogleSignInClient() {
        var googleSignInOptions = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
    }

    private fun initAuthViewModel() {
        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
    }

    private fun initSignInButton() {
        googleSignInButton = findViewById(R.id.google_button)
        googleSignInButton.setOnClickListener {
            signIn()
        }
    }

    private fun initFacebookSignInButton() {
        facebookloginbutton = findViewById(R.id.login_button)
        facebookloginbutton.setPermissions("email", "public_profile")
        facebookloginbutton.registerCallback(
            callbackManager,
            object : FacebookCallback<LoginResult> {
                override fun onSuccess(loginResult: LoginResult) {
                    Log.d("Main", "facebook:onSuccess:$loginResult")
                    getFacebookAuthCredential(loginResult.accessToken)
                    val user = firebaseAuth.currentUser

                }

                override fun onCancel() {
                    Log.d("Main", "facebook:onCancel")
                }

                override fun onError(error: FacebookException) {
                    Log.d("Main", "facebook:onError", error)
                }
            })
    }

    private fun signIn() {
        val intent = googleSignInClient.signInIntent
        startActivityForResult(intent, RC_SIGN_IN)
    }


    private fun goToSignedActivity(authentificatedUser: User) {
        val intent = Intent(this, SignedActivity::class.java)
        intent.putExtra("USER", authentificatedUser)
        startActivity(intent)
        finish()
    }





}