package com.example.tp_2_exo2.data.model
data class ReservationData(
    val userId: Int,
    val parkingId: Int,
    val placeId: Int,
    val date: String,
    val inTime: String,
    val outTime: String
)