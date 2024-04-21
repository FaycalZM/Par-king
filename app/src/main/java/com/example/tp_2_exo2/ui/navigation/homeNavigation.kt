package com.example.tp_2_exo2.ui.navigation

sealed class HomeNavigation(val route:String) {

    object SignIn: HomeNavigation("sign_in")
    object SignUp: HomeNavigation("sign_up")
}
