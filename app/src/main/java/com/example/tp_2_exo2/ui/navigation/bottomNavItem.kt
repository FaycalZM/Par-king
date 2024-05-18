package com.example.tp_2_exo2.ui.navigation

import com.example.tp_2_exo2.R
import com.example.tp_2_exo2.ui.navigation.routes.ParkingDestination

sealed class BottomNavItem(
    var title: String,
    var icon: Int,
    var icon_focused: Int,
    var route : String
) {
    object Home :
        BottomNavItem(
            "Home",
            R.drawable.ic_bottom_home,
            R.drawable.ic_bottom_home_focused,
            ParkingDestination.ParkingsList.route
        )

    object List :
        BottomNavItem(
            "List",
            R.drawable.ic_bottom_report,
            R.drawable.ic_bottom_reports_focused,
            ParkingDestination.ReservationsList.route
        )

    object Profile :
        BottomNavItem(
            "Profile",
            R.drawable.ic_bottom_profile,
            R.drawable.ic_bottom_profile_focused,
            ParkingDestination.Profile.route
        )
}