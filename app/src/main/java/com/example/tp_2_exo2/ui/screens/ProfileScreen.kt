package com.example.tp_2_exo2.ui.screens

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.tp_2_exo2.ui.composables.BottomNavigation
import com.example.tp_2_exo2.ui.navigation.routes.AuthDestination


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(
    navController: NavHostController
) {

    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val context = LocalContext.current
            val pref = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
            val email = pref.getString("email" , null)
            Log.d("Profile Screen", "ProfileScreen: $email ")
            if (email != null) {
                Text(text = email)
                Button(onClick = {
                    pref.edit().remove("email").apply()
                    navController.navigate(AuthDestination.SignIn.route)
                }) {
                    Text(text = "Sign out")
                }
            }
            else {
                Text(text = "User is not authenticated!")
                Button(onClick = {
                    navController.navigate(AuthDestination.SignIn.route)
                }) {
                    Text(text = "Sign in")
                }
            }

        }
    }
}