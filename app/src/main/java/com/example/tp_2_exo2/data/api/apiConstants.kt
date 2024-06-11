package com.example.tp_2_exo2.data.api

object apiConstants {
    // Backend Base URL

    const val BASE_URL = "https://330a-105-235-130-29.ngrok-free.app/"

    // Endpoints
    const val REGISTER = "registerUser"
    const val LOGIN = "login"

    // parkings endpoints
    const val GETALLPARKINGS = "parkingsList"
    const val GETPARKING = "parking"
    const val GETPARKINGIMAGE = "parkingImage"

    const val GET_RESERVATIONS = "userReservations"
    const val CREATE_RESERVATION = "createReservation"
    const val GET_QRCODE = "qrCode"
}