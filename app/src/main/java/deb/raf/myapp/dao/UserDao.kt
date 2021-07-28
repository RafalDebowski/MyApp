package deb.raf.myapp.dao

import androidx.room.*
import deb.raf.myapp.model.User

@Dao
interface UserDao {

        @Query("SELECT * FROM users")
        fun getAllUsers(): List<User>

        @Insert
         fun addAll(users: List<User>)

        @Insert
        fun addOne(user: User)

        @Delete
        fun deleteUser(user: User)

}