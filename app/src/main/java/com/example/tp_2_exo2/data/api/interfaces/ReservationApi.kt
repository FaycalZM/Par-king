package com.example.tp_2_exo2.data.api.interfaces

import com.example.tp_2_exo2.data.api.apiConstants
import com.example.tp_2_exo2.data.api.types.ReservationRequest
import com.example.tp_2_exo2.data.api.types.ReservationResponse
import com.example.tp_2_exo2.data.model.ReservationData
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

interface ReservationApi {
    @GET(apiConstants.GET_RESERVATIONS + "/{userId}")
    suspend fun getUserReservations(@Path("userId") userId:String): Response<List<ReservationData>>

    @POST(apiConstants.CREATE_RESERVATION)
    suspend fun createReservation(@Body reservation: ReservationRequest): Response<ReservationResponse>

    companion object {
        var endpoint: ReservationApi? = null
        fun createEndpoint(): ReservationApi {
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
                    .create(ReservationApi::class.java)
            }

            return endpoint!!
        }
    }
}