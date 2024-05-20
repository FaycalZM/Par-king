package com.example.tp_2_exo2.data.api.interfaces

import com.example.tp_2_exo2.data.api.apiConstants
import com.example.tp_2_exo2.data.api.types.AuthRequest
import com.example.tp_2_exo2.data.api.types.AuthResponse
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap
import java.util.concurrent.TimeUnit

interface AuthApi {
    @Multipart
    @POST(apiConstants.REGISTER)
    suspend fun registerUser(@PartMap user:MutableMap<String,RequestBody>):Response<AuthResponse>

    @POST(apiConstants.LOGIN)
    suspend fun loginUser(@Body user: AuthRequest ):Response<AuthResponse>

    companion object {
        var endpoint: AuthApi? = null
        fun createEndpoint(): AuthApi {
            if(endpoint ==null) {
                val client = OkHttpClient.Builder()
                    .connectTimeout(30,TimeUnit.SECONDS)
                    .readTimeout(30,TimeUnit.SECONDS)
                    .writeTimeout(30,TimeUnit.SECONDS)
                    .build()
                endpoint = Retrofit.Builder()
                    .client(client)
                    .baseUrl(apiConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(AuthApi::class.java)
            }
            return endpoint!!
        }

    }
}

