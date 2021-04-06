package deb.raf.myapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.facebook.AccessToken
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import deb.raf.myapp.model.User


class AuthRepository {
    private var firebaseAuth = FirebaseAuth.getInstance()
    private var rootRef = FirebaseFirestore.getInstance()
    private var usersRef = rootRef.collection("users")

    fun firebaseSignInWithGoogle(authCredential: AuthCredential): MutableLiveData<User> {

        var authenticatedUserMutableLiveData = MutableLiveData<User>()

        firebaseAuth.signInWithCredential(authCredential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val isNewUser = task.getResult()?.additionalUserInfo?.isNewUser
                    val user = firebaseAuth.currentUser

                    if (user != null) {
                        val uid = firebaseAuth.currentUser.uid
                        val name = firebaseAuth.currentUser.displayName
                        val email = firebaseAuth.currentUser.email

                        val user = User(uid, name, email)
                        user.isNew = isNewUser
                        authenticatedUserMutableLiveData.postValue(user)

                    }
                } else {
                    Log.w("Main", "signInWithCredential:failure", task.exception)
                }
            }
        return authenticatedUserMutableLiveData
    }

    fun firebaseSignInWithFacebook(accessToken: AccessToken): MutableLiveData<User> {

        var authenticatedUserMutableLiveData = MutableLiveData<User>()

        val credential = FacebookAuthProvider.getCredential(accessToken.token)

        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val isNewUser = task.getResult()?.additionalUserInfo?.isNewUser
                    val user = firebaseAuth.currentUser

                    if (user != null) {
                        val uid = firebaseAuth.currentUser.uid
                        val name = firebaseAuth.currentUser.displayName
                        val email = " firebaseAuth.currentUser.email"

                        val user = User(uid, name, email)
                        user.isNew = isNewUser
                        authenticatedUserMutableLiveData.postValue(user)

                    }
                } else {
                    Log.w("Main", "signInWithCredential:failure", task.exception)
                }
            }
        return authenticatedUserMutableLiveData
    }


    fun createUser(authenticatedUser: User): LiveData<User> {
        val newUserMutableLiveData = MutableLiveData<User>()
        val uidRef: DocumentReference = usersRef.document(authenticatedUser.uid)
        uidRef.get().addOnCompleteListener { uidTask: Task<DocumentSnapshot?> ->
            if (uidTask.isSuccessful) {
                val document = uidTask.result
                if (!document!!.exists()) {
                    uidRef.set(authenticatedUser)
                        .addOnCompleteListener { userCreationTask: Task<Void?> ->
                            if (userCreationTask.isSuccessful) {
                                authenticatedUser.isCreated = true
                                newUserMutableLiveData.setValue(authenticatedUser)
                            } else {
                                Log.e("TAG", userCreationTask.exception.toString())
                            }
                        }
                } else {
                    newUserMutableLiveData.setValue(authenticatedUser)
                }
            } else {
                Log.e("TAG", uidTask.exception.toString())
            }
        }
        return newUserMutableLiveData
    }

}
