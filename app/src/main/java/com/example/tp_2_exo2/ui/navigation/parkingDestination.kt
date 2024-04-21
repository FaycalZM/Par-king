package com.example.tp_2_exo2.ui.navigation

sealed class ParkingDestination(val route:String) {

    object Profile: ParkingDestination("_profile")
    object ParkingsList: ParkingDestination("parkingsList")

    object ReservationsList: ParkingDestination("reservations_list")
    object ParkingDetails: ParkingDestination("parkingDetails/{ParkingId}"){
        fun createRoute(id:Int) = "parkingDetails/$id"
    }
}