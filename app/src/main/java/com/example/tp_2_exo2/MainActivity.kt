package com.example.tp_2_exo2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.tp_2_exo2.data.api.interfaces.AuthApi
import com.example.tp_2_exo2.data.model.auth.AuthViewModel
import com.example.tp_2_exo2.repository.AuthRepository
import com.example.tp_2_exo2.ui.navigation.AuthNavigation
import com.example.tp_2_exo2.ui.theme.TP_2_EXO2Theme


class MainActivity : ComponentActivity() {

    val authApi = AuthApi.createEndpoint()
    val authRepository by lazy { AuthRepository(authApi) }
    val authModel = AuthViewModel.Factory(authRepository).create(AuthViewModel::class.java)


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


