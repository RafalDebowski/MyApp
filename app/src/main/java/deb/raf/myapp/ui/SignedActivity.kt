package deb.raf.myapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import dagger.android.support.DaggerAppCompatActivity
import deb.raf.myapp.R
import deb.raf.myapp.ViewModel.AuthViewModel

class SignedActivity : DaggerAppCompatActivity() {
    private val RC_SIGN_IN = 123

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authViewModel: AuthViewModel

    private lateinit var logoutButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signed)

        initGoogleSignInClient()
        firebaseAuth = FirebaseAuth.getInstance()
        logoutButton = findViewById(R.id.logout_button)


        logoutButton.setOnClickListener {
            signOut()
        }

    }


    private fun signOut() {
        firebaseAuth.signOut()
        googleSignInClient.signOut()
        LoginManager.getInstance().logOut()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun initGoogleSignInClient() {
        var googleSignInOptions = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
    }




}

