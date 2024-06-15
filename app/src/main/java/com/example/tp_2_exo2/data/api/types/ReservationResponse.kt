package com.example.tp_2_exo2.data.api.types

data class ReservationResponse(
    val id: Int,
    val reservation_id: Int,
    val amount: Int,
    val qr_code: String,
    val is_paid: Boolean
)
