package com.example.tp_2_exo2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.tp_2_exo2.data.ParkingApplication
import com.example.tp_2_exo2.data.model.auth.AuthViewModel
import com.example.tp_2_exo2.data.model.user.UserModel
import com.example.tp_2_exo2.ui.navigation.AuthNavigation
import com.example.tp_2_exo2.ui.theme.TP_2_EXO2Theme


class MainActivity : ComponentActivity() {

    private val userModel:UserModel by viewModels {
        UserModel.Factory(ParkingApplication(applicationContext).userRepository)
    }

    private val authModel:AuthViewModel by viewModels {
        AuthViewModel.Factory(ParkingApplication(applicationContext).userRepository)
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
                    val navController = rememberNavController()
                    AuthNavigation(
                        navController = navController,
                        authModel = authModel
                    )
            }
        }
    }
}
}


