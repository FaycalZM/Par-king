package com.example.tp_2_exo2.data.model.parking

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "parking_places",
    foreignKeys = [
        ForeignKey(
            entity = Parking::class,
            parentColumns = ["parkingId"],
            childColumns = ["parking"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ParkingPlace(
    @PrimaryKey(autoGenerate = true)
    var parkingPlaceId:Int = 0,
    var parking:Int,
    var placeNumber:Int?,
)