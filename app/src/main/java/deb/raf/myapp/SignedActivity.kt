package deb.raf.myapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.facebook.login.LoginManager
import com.facebook.login.widget.LoginButton
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import deb.raf.myapp.ViewModel.AuthViewModel

class SignedActivity : AppCompatActivity() {
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

