package com.example.tp_2_exo2.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tp_2_exo2.data.model.user.User

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getAllUsers():List<User>

    @Query("SELECT * FROM users WHERE firstName LIKE :firstName")
    fun getUsersByFirstName(firstName:String):List<User>

    @Query("SELECT * FROM users WHERE email=:email LIMIT 1")
    fun getUserByEmail(email:String):User?
    @Insert
    fun addUsers(vararg users: User)

    @Insert
    fun addUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)
}