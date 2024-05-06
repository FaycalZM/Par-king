package com.example.tp_2_exo2.data

import android.app.Application
import android.content.Context
import com.example.tp_2_exo2.data.database.AppDatabase
import com.example.tp_2_exo2.repository.UserRepository

class ParkingApplication(
    private val context: Context
) : Application() {
    private val database by lazy {
        AppDatabase.getDBInstance(context)
    }
    // Data Access Objects (DAOs)
    private val userDao by lazy {
        this.database.getUserDao()
    }
    private val parkingDao by lazy {
        this.database.getParkingDao()
    }
    private val reservationDao by lazy {
        this.database.getReservationDao()
    }

    // Repositories
    val userRepository by lazy {
        UserRepository(this.userDao)
    }
}