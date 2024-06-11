package com.example.tp_2_exo2.ui.navigation

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tp_2_exo2.data.model.auth.AuthViewModel
import com.example.tp_2_exo2.data.model.user.UserModel
import com.example.tp_2_exo2.data.utils.parkingsList
import com.example.tp_2_exo2.data.utils.reservationsList
import com.example.tp_2_exo2.ui.navigation.routes.AuthDestination
import com.example.tp_2_exo2.ui.navigation.routes.ParkingDestination
import com.example.tp_2_exo2.ui.screens.ParkingsListScreen
import com.example.tp_2_exo2.ui.screens.ProfileScreen
import com.example.tp_2_exo2.ui.screens.ReservationsListScreen
import com.example.tp_2_exo2.ui.screens.SignInScreen
import com.example.tp_2_exo2.ui.screens.SignUpScreen

@Composable
fun AuthNavigation(
    navController: NavHostController,
    authModel: AuthViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = AuthDestination.SignIn.route
    ) {
        composable(AuthDestination.SignIn.route) {
            val context = LocalContext.current
            // if the user is already logged in : go directly to the home screen
            LaunchedEffect(key1 = Unit) {
                val sharedPreferences = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
                val userId = sharedPreferences.getString("id" , null)
                if (userId != null) {
                    navController.navigate(ParkingDestination.ReservationsList.route)
                }
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
            ProfileScreen(
                navController = navController,
            )
        }

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
                parkingsList = parkingsList,
                navController = navController
            )
        }
    }
}