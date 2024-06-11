package com.example.tp_2_exo2.data.model
data class ReservationData(
    val id:Int,
    val user_id: Int,
    val parking_id: Int,
    val place_id: Int,
    val date: String,
    val in_time: String,
    val out_time: String
)