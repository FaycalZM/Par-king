package com.example.tp_2_exo2.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tp_2_exo2.data.model.parking.Parking


@Dao
interface ParkingDao {
    @Query("SELECT * FROM parkings")
    fun getAllParkings():List<Parking>
    @Insert
    fun addParking(parking: Parking)
    @Update
    fun updateParking(parking: Parking)
    @Delete
    fun deleteParking(parking: Parking)
}