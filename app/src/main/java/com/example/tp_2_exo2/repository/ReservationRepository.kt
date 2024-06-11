package com.example.tp_2_exo2.repository

import com.example.tp_2_exo2.data.api.interfaces.ReservationApi
import com.example.tp_2_exo2.data.model.ParkingData
import com.example.tp_2_exo2.data.model.ReservationData
import retrofit2.Response

class ReservationRepository(
    private val reservationApi: ReservationApi
) {
    suspend fun getUserReservations(userId: String): Response<List<ReservationData>> {
        return reservationApi.getUserReservations(userId)
    }
}