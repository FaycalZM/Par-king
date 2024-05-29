package com.example.tp_2_exo2.data.utils

import com.example.tp_2_exo2.R
import com.example.tp_2_exo2.data.model.ParkingData
import com.example.tp_2_exo2.data.model.ReservationData


val reservationsList = listOf<ReservationData>(
    ReservationData(0,"Parking1","fayssal"),
    ReservationData(1,"Parking1","fayssal"),
    ReservationData(2,"Parking2","fayssal"),
    ReservationData(3,"Parking3","fayssal"),
)

val parkingsList = listOf(
    ParkingData(
        id = 1,
        name = "Parking 1",
        description = "Convenient downtown parking with easy access to main attractions easy access to main attractions Convenient downtown parking with easy access to main attractions easy access to main attractions ",
        wilaya = "Wilaya 1",
        address = "Address 1",
        parking_img = "news_1.jpg",
        localization = "Localization 1",
        price_per_hour = 10,
        opening_time = "08:00:00",
        closing_time = "18:00:00"
    ),
    ParkingData(
        id = 2,
        name = "Parking 2",
        description = "Convenient downtown parking with easy access to main attractions",
        wilaya = "Wilaya 2",
        address = "Address 2",
        parking_img = "news_2.jpg",
        localization = "Localization 2",
        price_per_hour = 15,
        opening_time = "09:00:00",
        closing_time = "19:00:00"
    ),
    ParkingData(
        id = 3,
        name = "Parking 3",
        description = "Convenient downtown parking with easy access to main attractions",
        wilaya = "Wilaya 3",
        address = "Address 3",
        parking_img = "news_3.jpg",
        localization = "Localization 3",
        price_per_hour = 20,
        opening_time = "00:00:00",
        closing_time = "23:59:00"
    ),
    ParkingData(
        id = 4,
        name = "Parking 4",
        description = "Convenient downtown parking with easy access to main attractions",
        wilaya = "Wilaya 4",
        address = "Address 4",
        parking_img = "news_4.jpg",
        localization = "Localization 4",
        price_per_hour = 5,
        opening_time = "07:00:00",
        closing_time = "17:00:00"
    ),
    ParkingData(
        id = 5,
        name = "Parking 5",
        description = "Convenient downtown parking with easy access to main attractions",
        wilaya = "Wilaya 5",
        address = "Address 5",
        parking_img = "news_5.jpg",
        localization = "Localization 5",
        price_per_hour = 8,
        opening_time = "10:00:00",
        closing_time = "20:00:00"
    )
)

