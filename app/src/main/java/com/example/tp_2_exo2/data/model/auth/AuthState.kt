package com.example.tp_2_exo2.data.model.auth

import com.example.tp_2_exo2.data.model.user.User

data class AuthState(
    val isLoading : Boolean = false,
    val responseMsg : String = "",
    val activeUser : User? = null
)