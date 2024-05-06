package com.example.tp_2_exo2.ui.navigation.routes

sealed class ParkingDestination(val route:String) {

    object Profile: ParkingDestination("profile")
    object ParkingsList: ParkingDestination("parkings_list")
    object ReservationsList: ParkingDestination("reservations_list")
    object ParkingDetails: ParkingDestination("parkingDetails/{ParkingId}"){
        fun createRoute(id:Int) = "parkingDetails/$id"
    }
}