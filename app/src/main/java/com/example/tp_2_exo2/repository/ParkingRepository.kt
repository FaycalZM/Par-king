package com.example.tp_2_exo2.repository

import com.example.tp_2_exo2.data.api.interfaces.ParkingApi
import com.example.tp_2_exo2.data.model.ParkingData
import retrofit2.Response

class ParkingRepository (private val parkingApi: ParkingApi) {
    suspend fun getAllParkings(): Response<List<ParkingData>> {
        return parkingApi.getAllParkings()
    }

    suspend fun getParkingById(id: String): Response<ParkingData> {
        return parkingApi.getParkingById(id)
    }
}