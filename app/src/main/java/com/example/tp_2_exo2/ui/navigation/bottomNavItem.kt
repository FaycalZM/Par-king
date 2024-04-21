package com.example.tp_2_exo2.ui.navigation

import com.example.tp_2_exo2.R

sealed class BottomNavItem(
    var title: String,
    var icon: Int,
    var route : String
) {
    object Home :
        BottomNavItem(
            "Home",
            R.drawable.baseline_home,
            ParkingDestination.ParkingsList.route
        )

    object List :
        BottomNavItem(
            "List",
            R.drawable.baseline_list,
            ParkingDestination.ReservationsList.route
        )

    object Profile :
        BottomNavItem(
            "Profile",
            R.drawable.baseline_person,
            ParkingDestination.Profile.route
        )
}