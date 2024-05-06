package com.example.tp_2_exo2.data.model.user

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName ="users" )
data class User(
    @PrimaryKey(autoGenerate = true)
    var userId:Int = 0,
    var firstName:String?,
    var lastName:String?,
    var email:String,
    var password:String
)