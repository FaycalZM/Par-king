package com.example.tp_2_exo2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tp_2_exo2.data.model.Parking
import com.example.tp_2_exo2.ui.screens.ProfileScreen
import com.example.tp_2_exo2.data.model.UserData
import com.example.tp_2_exo2.ui.composables.ParkingDetails
import com.example.tp_2_exo2.ui.composables.ParkingsListComposable

@Composable
fun ParkingNavigation(
    parkingsList: List<Parking>,
    userData: UserData?,
    onSignOut : () -> Unit,
    navController : NavHostController){

    NavHost(navController = navController, startDestination = "parkingsList"){
        composable(ParkingDestination.Profile.route){ ProfileScreen(userData = userData , onSignOut=onSignOut) }
        composable(ParkingDestination.ParkingsList.route){ ParkingsListComposable(parkingsList,navController) }
        composable(ParkingDestination.ParkingDetails.route){
                navBack ->
            val id = navBack.arguments?.getString("ParkingId")?.toInt()
            ParkingDetails(parkingsList[id!!])
        }
    }
}