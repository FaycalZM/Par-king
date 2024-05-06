package com.example.tp_2_exo2.data.model.reservation



import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName ="reservations",
    primaryKeys = ["userId","parkingPlaceId"]
)
data class Reservation(
    var userId:Int,
    var parkingPlaceId:Int,
    var startTime:String?,
    var endTime:String?,
)