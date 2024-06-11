package com.example.tp_2_exo2.ui.navigation

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.tp_2_exo2.data.ViewModels.ParkingViewModel
import com.example.tp_2_exo2.data.ViewModels.ReservationViewModel
import com.example.tp_2_exo2.data.api.interfaces.ParkingApi
import com.example.tp_2_exo2.data.api.interfaces.ReservationApi
import com.example.tp_2_exo2.data.model.auth.AuthViewModel

import com.example.tp_2_exo2.ui.navigation.routes.AuthDestination
import com.example.tp_2_exo2.ui.navigation.routes.ParkingDestination
import com.example.tp_2_exo2.ui.screens.MapScreen
import com.example.tp_2_exo2.ui.screens.ParkingsListScreen
import com.example.tp_2_exo2.ui.screens.ProfileScreen
import com.example.tp_2_exo2.ui.screens.ReservationsListScreen
import com.example.tp_2_exo2.ui.screens.SignInScreen
import com.example.tp_2_exo2.ui.screens.SignUpScreen
import com.example.tp_2_exo2.repository.ParkingRepository
import com.example.tp_2_exo2.repository.ReservationRepository
import com.example.tp_2_exo2.ui.screens.ParkingDetailsScreen

@Composable
fun AuthNavigation(
    navController: NavHostController,
    authModel: AuthViewModel,
) {
    val parkingApi = ParkingApi.createEndpoint()
    val parkingRepository by lazy { ParkingRepository(parkingApi) }
    val parkingViewModel = ParkingViewModel.Factory(parkingRepository).create(ParkingViewModel::class.java)

    val reservationsApi = ReservationApi.createEndpoint()
    val reservationRepository by lazy { ReservationRepository(reservationsApi) }
    val reservationViewModel = ReservationViewModel.Factory(reservationRepository).create(ReservationViewModel::class.java)


    NavHost(
        navController = navController,
        startDestination = AuthDestination.SignIn.route
    ) {
        composable(AuthDestination.SignIn.route) {

            val context = LocalContext.current
            val sharedPreferences = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

            val userId = sharedPreferences.getString("id" , null)
            if (userId != null) {
                navController.navigate(ParkingDestination.Profile.route)
            }

            SignInScreen(
                navController = navController,
                authViewModel = authModel
            )
        }

        composable(AuthDestination.SignUp.route) {
            SignUpScreen(
                navController = navController,
                authViewModel = authModel
            )
        }

        composable(
            ParkingDestination.Profile.route
        ){
            val context = LocalContext.current
            val pref = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
            val userId = pref.getString("id" , null)
            Log.d("navigation", "ProfileScreen: $userId ")
            ProfileScreen(
                navController = navController,
                userId = userId,
                sharedPreferences = pref
            )
        }

        composable(
            ParkingDestination.ReservationsList.route
        ) {
            ReservationsListScreen(
                parkingViewModel = parkingViewModel,
                reservationsViewModel = reservationViewModel,
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

        composable(
                "ParkingDetailsScreen/{ParkingId}",
                    arguments = listOf(navArgument("ParkingId") { type = NavType.IntType }
            )
        ){
                backStackEntry ->
            val id = backStackEntry.arguments?.getInt("ParkingId")
            ParkingDetailsScreen(
                parkingViewModel = parkingViewModel,
                navController = navController,
                parkingId = id!!.toInt()
            )
        }
        composable(

        composable(
            ParkingDestination.Cart.route
        ) {
            MapScreen(
               parkingViewModel = parkingViewModel,
               navController= navController
            )
        }
    }
}