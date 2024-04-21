package com.example.tp_2_exo2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tp_2_exo2.data.model.Parking
import com.example.tp_2_exo2.data.model.Reservation
import com.example.tp_2_exo2.ui.screens.ProfileScreen
import com.example.tp_2_exo2.data.model.UserData
import com.example.tp_2_exo2.ui.composables.ParkingDetails
import com.example.tp_2_exo2.ui.composables.ParkingsListComposable
import com.example.tp_2_exo2.ui.screens.ReservationsListScreen

@Composable
fun ParkingNavigation(
    parkingsList: List<Parking>,
    reservationsList : List<Reservation>,
    userData: UserData?,
    onSignOut : () -> Unit,
    navController : NavHostController){

    NavHost(navController = navController, startDestination = "parkingsList"){
        composable(
            ParkingDestination.Profile.route
        ){
            ProfileScreen(
                userData = userData ,
                onSignOut=onSignOut,
                navController = navController
            )
        }
        composable(
            ParkingDestination.ParkingsList.route
        ){
            ParkingsListComposable(
                parkingsList = parkingsList,
                navController = navController
            )
        }
        composable(
            ParkingDestination.ParkingDetails.route
        ){
                navBack ->
            val id = navBack.arguments?.getString("ParkingId")?.toInt()
            ParkingDetails(parkingsList[id!!])
        }
        composable(
            ParkingDestination.ReservationsList.route
        ) {
            ReservationsListScreen(reservationsList = reservationsList ,navController = navController)
        }
    }
}