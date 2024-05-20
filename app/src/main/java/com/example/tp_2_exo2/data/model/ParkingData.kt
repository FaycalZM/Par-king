package com.example.tp_2_exo2.data.model



data class ParkingData(
    val id: Int,
    val name: String,
    val description: String,
    val wilaya: String,
    val address: String,
    val parking_img: String,
    val localization: String,
    val price_per_hour: Int,
    val opening_time: String,
    val closing_time: String
)
