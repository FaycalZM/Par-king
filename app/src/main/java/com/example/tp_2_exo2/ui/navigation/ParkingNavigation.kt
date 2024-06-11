package com.example.tp_2_exo2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tp_2_exo2.data.ViewModels.ParkingViewModel
import com.example.tp_2_exo2.data.api.interfaces.ParkingApi
import com.example.tp_2_exo2.data.model.ParkingData
import com.example.tp_2_exo2.data.model.ReservationData
import com.example.tp_2_exo2.ui.screens.ProfileScreen

import com.example.tp_2_exo2.data.utils.parkingsList
import com.example.tp_2_exo2.data.utils.reservationsList
import com.example.tp_2_exo2.repository.ParkingRepository
import com.example.tp_2_exo2.ui.composables.ParkingDetails
import com.example.tp_2_exo2.ui.navigation.routes.ParkingDestination
import com.example.tp_2_exo2.ui.screens.ParkingsListScreen
import com.example.tp_2_exo2.ui.screens.ReservationsListScreen

@Composable
fun ParkingNavigation(
    navController: NavHostController
)
{
    val parkingApi = ParkingApi.createEndpoint()
    val parkingRepository by lazy { ParkingRepository(parkingApi) }
    val parkingViewModel = ParkingViewModel.Factory(parkingRepository).create(ParkingViewModel::class.java)

    NavHost(navController = navController, startDestination = ParkingDestination.Profile.route){
//        composable(
//            ParkingDestination.Profile.route
//        ){
//            ProfileScreen(
//                navController = navController,
//            )
//        }

        composable(
            ParkingDestination.ReservationsList.route
        ) {
            ReservationsListScreen(
                parkingsList = parkingsList,
                reservationList = reservationsList,
                navController = navController
            )
        }

        composable(
            ParkingDestination.ParkingsList.route
        ) {
            ParkingsListScreen(
                parkingViewModel = parkingViewModel,
                navController = navController
            )
        }
    }
}