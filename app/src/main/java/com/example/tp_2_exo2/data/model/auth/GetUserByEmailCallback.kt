package com.example.tp_2_exo2.data.model.auth

import com.example.tp_2_exo2.data.model.user.User

interface GetUserByEmailCallback {
    fun onUserRetrieved(user:User?)
}