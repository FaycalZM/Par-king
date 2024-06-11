package com.example.tp_2_exo2.data.api.interfaces

import com.example.tp_2_exo2.data.api.apiConstants
import com.example.tp_2_exo2.data.model.ParkingData
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

interface ParkingApi {
    @GET(apiConstants.GETALLPARKINGS)
    suspend fun getAllParkings(): Response<List<ParkingData>>

    @GET(apiConstants.GETPARKING + "/{id}")
    suspend fun getParkingById(@Path("id") id: String): Response<ParkingData>

    companion object {
        var endpoint: ParkingApi? = null
        fun createEndpoint(): ParkingApi {
            if (endpoint == null) {
                val client = OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .build()
                endpoint = Retrofit.Builder()
                    .client(client)
                    .baseUrl(apiConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ParkingApi::class.java)
            }

            return endpoint!!
        }
    }
}