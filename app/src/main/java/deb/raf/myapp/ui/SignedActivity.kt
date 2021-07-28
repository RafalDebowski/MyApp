package deb.raf.myapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import deb.raf.myapp.R
import deb.raf.myapp.ViewModel.AuthViewModel
import deb.raf.myapp.ui.forms.*
import javax.annotation.Signed

class SignedActivity : AppCompatActivity() {
    private val RC_SIGN_IN = 123

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authViewModel: AuthViewModel

    private lateinit var logoutButton:Button
    private lateinit var productButton:Button
    private lateinit var purchaseButton:Button
    private lateinit var plotOfLandButton:Button
    private lateinit var warehouseButton:Button
    private lateinit var sprayingButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signed)

        initGoogleSignInClient()
        firebaseAuth = FirebaseAuth.getInstance()
        logoutButton = findViewById(R.id.logout_button)
        productButton = findViewById(R.id.product_button)
        purchaseButton = findViewById(R.id.purchase_button)
        plotOfLandButton = findViewById(R.id.plotOfLand_button)
        warehouseButton = findViewById(R.id.warehouse_button)
        sprayingButton = findViewById(R.id.spraying_button)


        logoutButton.setOnClickListener {
            signOut()
        }


        productButton.setOnClickListener{
            goToProductActivity()
        }

        purchaseButton.setOnClickListener {
            goToPurchaseActivity()
        }

        plotOfLandButton.setOnClickListener {
            goToPlotOfLandActivity()
        }

        warehouseButton.setOnClickListener {
            goToWarehouseActivity()
        }
        sprayingButton.setOnClickListener {
            goToSprayingActivity()
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

    private fun goToProductActivity() {
        val intent = Intent(this, ProductActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun goToWarehouseActivity() {
        val intent = Intent(this, WarehouseActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun goToSprayingActivity() {
        val intent = Intent(this, SprayingActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun goToPlotOfLandActivity() {
        val intent = Intent(this, PlotOfLandActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun goToPurchaseActivity() {
        val intent = Intent(this, PurchaseActivity::class.java)
        startActivity(intent)
        finish()
    }






}

