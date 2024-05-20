package com.example.tp_2_exo2.repository

import com.example.tp_2_exo2.data.api.interfaces.AuthApi
import com.example.tp_2_exo2.data.api.types.AuthResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response

class AuthRepository(
    private val authApi : AuthApi
) {
    suspend fun registerUser( user: MutableMap<String,RequestBody>):Response<AuthResponse> {
        return authApi.registerUser(user)
    }

    suspend fun loginUser(credentials : Map<String,String>):Response<AuthResponse> {
        return  authApi.loginUser(credentials)
    }
}