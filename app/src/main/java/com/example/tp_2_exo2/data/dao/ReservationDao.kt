package com.example.tp_2_exo2.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.tp_2_exo2.data.model.reservation.Reservation


@Dao
interface ReservationDao {
    @Query("SELECT * FROM reservations WHERE userId=:userId")
    fun getUserReservations(userId:Int):List<Reservation>
    @Insert
    fun addReservation(reservation: Reservation)
    @Delete
    fun deleteReservation(reservation: Reservation)
}