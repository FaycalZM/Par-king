package com.example.tp_2_exo2.data.api.types


import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("id")
    val id: Int
)