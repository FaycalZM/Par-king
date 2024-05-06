package com.example.tp_2_exo2.repository

import com.example.tp_2_exo2.data.dao.UserDao
import com.example.tp_2_exo2.data.model.user.User

class UserRepository(
    private val userDao: UserDao
) {
    fun getAllUsers() = userDao.getAllUsers()
    fun getUserByEmail(email: String) = userDao.getUserByEmail(email)
    fun addUser(user: User) = userDao.addUser(user)
    fun addUsers(vararg users: User) = userDao.addUsers(*users)
    fun updateUser(user: User) = userDao.updateUser(user)
    fun deleteUser(user: User) = userDao.deleteUser(user)
}