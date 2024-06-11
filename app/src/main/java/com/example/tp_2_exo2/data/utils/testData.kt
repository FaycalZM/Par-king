package com.example.tp_2_exo2.data.utils
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalTime

import com.example.tp_2_exo2.R
import com.example.tp_2_exo2.data.model.ParkingData
import com.example.tp_2_exo2.data.model.ReservationData


val reservationsList = listOf(
    ReservationData(
        userId = 1,
        parkingId = 1,
        placeId = 1,
        date = "2021-01-02",
        inTime = "08:00",
        outTime = "09:00"
    ),
    ReservationData(
        userId = 2,
        parkingId = 1,
        placeId = 2,
        date = "2021-01-02",
        inTime = "09:00",
        outTime = "10:00"
    ),
    ReservationData(
        userId = 3,
        parkingId = 2,
        placeId = 3,
        date = "2021-01-02",
        inTime = "10:00",
        outTime = "11:00"
    ),
    ReservationData(
        userId = 4,
        parkingId = 2,
        placeId = 4,
        date = "2021-01-02",
        inTime = "11:00",
        outTime = "12:00"
    ),
    ReservationData(
        userId = 5,
        parkingId = 3,
        placeId = 5,
        date = "2021-01-02",
        inTime = "12:00",
        outTime = "13:00"
    ),
    ReservationData(
        userId = 1,
        parkingId = 3,
        placeId = 6,
        date = "2021-01-02",
        inTime = "13:00",
        outTime = "14:00"
    ),
    ReservationData(
        userId = 2,
        parkingId = 4,
        placeId = 7,
        date = "2021-01-02",
        inTime = "14:00",
        outTime = "15:00"
    ),
    ReservationData(
        userId = 3,
        parkingId = 4,
        placeId = 8,
        date = "2021-01-02",
        inTime = "15:00",
        outTime = "16:00"
    ),
    ReservationData(
        userId = 4,
        parkingId = 5,
        placeId = 9,
        date = "2021-01-02",
        inTime = "16:00",
        outTime = "17:00"
    ),
    ReservationData(
        userId = 5,
        parkingId = 5,
        placeId = 10,
        date = "2021-01-02",
        inTime = "17:00",
        outTime = "18:00"
    )
)


val parkingsList = listOf(
    ParkingData(
        id = 1,
        name = "Parking 1",
        description = "Convenient downtown parking with easy access to main attractions easy access to main attractions Convenient downtown parking with easy access to main attractions easy access to main attractions ",
        wilaya = "Wilaya 1",
        address = "Address 1",
        parking_img = "news_1.jpg",
        localization = "36.72552366510203, 3.031679824855004",
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
        localization = "36.70763511705145, 3.2417933446262763",
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
        localization = "36.657583964003166, 3.0040114719297173",
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
        localization = "36.726472185800375, 3.08296983835037",
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
        localization = "36.75194120311943, 3.056650382876819",
        price_per_hour = 8,
        opening_time = "10:00:00",
        closing_time = "20:00:00"
    )
)

