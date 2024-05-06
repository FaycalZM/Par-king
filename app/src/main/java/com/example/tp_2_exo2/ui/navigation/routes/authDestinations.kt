package com.example.tp_2_exo2.ui.navigation.routes

sealed class AuthDestination(val route:String) {

    object SignIn: AuthDestination("sign_in")
    object SignUp: AuthDestination("sign_up")

    object Home: AuthDestination("home")
}
