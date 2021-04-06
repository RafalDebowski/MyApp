package deb.raf.myapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.facebook.AccessToken
import com.google.firebase.auth.AuthCredential
import deb.raf.myapp.model.User
import deb.raf.myapp.repository.AuthRepository

class AuthViewModel() : ViewModel() {

    lateinit var authenticatedUserLiveData: LiveData<User>
    var authRepository = AuthRepository()
    lateinit var createdUserLiveData: LiveData<User>

    fun signInWithGoogle(googleAuthCredential: AuthCredential) {
        authenticatedUserLiveData = authRepository.firebaseSignInWithGoogle(googleAuthCredential)
    }

    fun signInWithFacebook(accessToken: AccessToken) {
        authenticatedUserLiveData = authRepository.firebaseSignInWithFacebook(accessToken)
    }


    fun createUser(authenticatedUser: User) {
        createdUserLiveData = authRepository.createUser(authenticatedUser)
    }


}