package deb.raf.myapp.model

import java.io.Serializable

class User(
    val name: String,
    val uid: String,
    val email: String,
    ) :Serializable{
     val isAuthenticated: Boolean? = false

    var isNew: Boolean? = false
    var isCreated: Boolean? = false


}