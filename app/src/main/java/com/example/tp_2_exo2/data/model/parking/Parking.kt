package com.example.tp_2_exo2.data.model.parking

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "parkings")
data class Parking(
    @PrimaryKey(autoGenerate = true)
    var parkingId:Int = 0,
    var name:String,
    var capacity:Int,
    var openingTime:String,
    var closingTime:String,
    var city:String,
    var picture:Int,
    var description:String
)


