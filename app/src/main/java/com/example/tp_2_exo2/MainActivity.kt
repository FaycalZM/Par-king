package com.example.tp_2_exo2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tp_2_exo2.data.model.Parking
import com.example.tp_2_exo2.data.model.Reservation
import com.example.tp_2_exo2.data.utils.GoogleAuthUiClient
import com.example.tp_2_exo2.ui.screens.SignInScreen
import com.example.tp_2_exo2.data.model.SignInViewModel
import com.example.tp_2_exo2.ui.navigation.BottomNavigation
import com.example.tp_2_exo2.ui.navigation.HomeNavigation
import com.example.tp_2_exo2.ui.navigation.ParkingNavigation
import com.example.tp_2_exo2.ui.screens.SignUpScreen
import com.example.tp_2_exo2.ui.theme.TP_2_EXO2Theme
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TP_2_EXO2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val homeNavController = rememberNavController()
                    NavHost(navController = homeNavController, startDestination = "profile") {

                        composable(HomeNavigation.SignIn.route) {

                            val viewModel = viewModel<SignInViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()

                            // if the user is already logged in : go directly to the profile screen
                            LaunchedEffect(key1 = Unit) {
                                if(googleAuthUiClient.getSignedInUser() != null) {
                                    homeNavController.navigate("profile")
                                }
                            }

                            val launcher = rememberLauncherForActivityResult(
                                contract = ActivityResultContracts.StartIntentSenderForResult(),
                                onResult = { result ->
                                    if(result.resultCode == RESULT_OK) {
                                        lifecycleScope.launch {
                                            val signInResult = googleAuthUiClient.signInWithIntent(
                                                intent = result.data ?: return@launch
                                            )
                                            viewModel.onSignInResult(signInResult)
                                        }
                                    }
                                }
                            )

                            // when the user is signed in successfully : display a Toast and
                            // navigate to the profile screen
                            LaunchedEffect(key1 = state.isSignInSuccessful) {
                                if(state.isSignInSuccessful) {
                                    Toast.makeText(
                                        applicationContext,
                                        "Signed in successfully",
                                        Toast.LENGTH_LONG
                                    ).show()

                                    homeNavController.navigate("profile")
                                    viewModel.resetState()
                                }
                            }

                            SignInScreen(
                                state = state,
                                onSignInClick = {
                                    lifecycleScope.launch {
                                        val signInIntentSender = googleAuthUiClient.signIn()
                                        launcher.launch(
                                            IntentSenderRequest.Builder(
                                                signInIntentSender ?: return@launch
                                            ).build()
                                        )
                                    }
                                },
                                homeNavController
                            )
                        }

                        composable(HomeNavigation.SignUp.route) {

                            val viewModel = viewModel<SignInViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()

                            // if the user is already logged in : go directly to the profile screen
                            LaunchedEffect(key1 = Unit) {
                                if(googleAuthUiClient.getSignedInUser() != null) {
                                    homeNavController.navigate("profile")
                                }
                            }

                            val launcher = rememberLauncherForActivityResult(
                                contract = ActivityResultContracts.StartIntentSenderForResult(),
                                onResult = { result ->
                                    if(result.resultCode == RESULT_OK) {
                                        lifecycleScope.launch {
                                            val signInResult = googleAuthUiClient.signInWithIntent(
                                                intent = result.data ?: return@launch
                                            )
                                            viewModel.onSignInResult(signInResult)
                                        }
                                    }
                                }
                            )

                            // when the user is signed in successfully : display a Toast and
                            // navigate to the profile screen
                            LaunchedEffect(key1 = state.isSignInSuccessful) {
                                if(state.isSignInSuccessful) {
                                    Toast.makeText(
                                        applicationContext,
                                        "Signed in successfully",
                                        Toast.LENGTH_LONG
                                    ).show()

                                    homeNavController.navigate("profile")
                                    viewModel.resetState()
                                }
                            }

                            SignUpScreen(
                                state = state,
                                onSignInClick = {
                                    lifecycleScope.launch {
                                        val signInIntentSender = googleAuthUiClient.signIn()
                                        launcher.launch(
                                            IntentSenderRequest.Builder(
                                                signInIntentSender ?: return@launch
                                            ).build()
                                        )
                                    }
                                },
                                homeNavController
                            )
                        }

                        composable("profile") {

                            val user_data = googleAuthUiClient.getSignedInUser() // signed in user' informations (for profile screen)

                            val parkingsList = listOf<Parking>(
                                Parking(0,"Parking1", "50", "8 AM - 6 PM", "123 Main St", "Cityville", R.drawable.pic3, "This is a description for Parking1."),
                                Parking(1,"Parking2", "75", "9 AM - 7 PM", "456 Oak St", "Townsville", R.drawable.pic2, "This is a description for Parking2."),
                                Parking(2,"Parking3", "100", "24/7", "789 Pine St", "Metropolis", R.drawable.pic3, "This is a description for Parking3."),
                                Parking(3,"Parking4", "30", "7 AM - 5 PM", "101 Elm St", "Villagetown", R.drawable.pic4, "This is a description for Parking4."),
                                Parking(4,"Parking5", "80", "10 AM - 8 PM", "202 Maple St", "Suburbia", R.drawable.pic5, "This is a description for Parking5.")
                            )

                            val reservationsList = listOf<Reservation>(
                                Reservation(0,"Parking1","fayssal"),
                                Reservation(1,"Parking1","fayssal"),
                                Reservation(2,"Parking2","fayssal"),
                                Reservation(3,"Parking3","fayssal"),
                            )
                            val parkingNavController = rememberNavController()
                            ParkingNavigation(
                                parkingsList = parkingsList,
                                reservationsList = reservationsList,
                                userData = user_data,
                                onSignOut = {
                                    lifecycleScope.launch {
                                        googleAuthUiClient.signOut()
                                        Toast.makeText(
                                            applicationContext,
                                            "Signed out",
                                            Toast.LENGTH_LONG
                                        ).show()

                                        homeNavController.popBackStack()
                                    }
                                },
                                navController = parkingNavController
                            )
                        }
                    }
            }
        }
    }
}
}


