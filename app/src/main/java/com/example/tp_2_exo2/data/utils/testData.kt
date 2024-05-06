package com.example.tp_2_exo2.data.utils

import com.example.tp_2_exo2.R
import com.example.tp_2_exo2.data.model.ParkingData
import com.example.tp_2_exo2.data.model.ReservationData

val parkingsList = listOf<ParkingData>(
    ParkingData(0,"Parking1", "50", "8 AM - 6 PM", "123 Main St", "Cityville", R.drawable.pic3, "This is a description for Parking1."),
    ParkingData(1,"Parking2", "75", "9 AM - 7 PM", "456 Oak St", "Townsville", R.drawable.pic2, "This is a description for Parking2."),
    ParkingData(2,"Parking3", "100", "24/7", "789 Pine St", "Metropolis", R.drawable.pic3, "This is a description for Parking3."),
    ParkingData(3,"Parking4", "30", "7 AM - 5 PM", "101 Elm St", "Villagetown", R.drawable.pic4, "This is a description for Parking4."),
    ParkingData(4,"Parking5", "80", "10 AM - 8 PM", "202 Maple St", "Suburbia", R.drawable.pic5, "This is a description for Parking5.")
)

val reservationsList = listOf<ReservationData>(
    ReservationData(0,"Parking1","fayssal"),
    ReservationData(1,"Parking1","fayssal"),
    ReservationData(2,"Parking2","fayssal"),
    ReservationData(3,"Parking3","fayssal"),
)