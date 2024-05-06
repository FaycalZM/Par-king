package com.example.tp_2_exo2.data.database



import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tp_2_exo2.data.dao.ParkingDao
import com.example.tp_2_exo2.data.dao.ReservationDao
import com.example.tp_2_exo2.data.dao.UserDao
import com.example.tp_2_exo2.data.model.parking.Parking
import com.example.tp_2_exo2.data.model.parking.ParkingPlace
import com.example.tp_2_exo2.data.model.reservation.Reservation
import com.example.tp_2_exo2.data.model.user.User

@Database(
    entities = [
        User::class,
        Parking::class,
        ParkingPlace::class,
        Reservation::class
    ]
    ,version = 2
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getUserDao(): UserDao
    abstract fun getParkingDao(): ParkingDao
    abstract fun getReservationDao(): ReservationDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDBInstance(context: Context): AppDatabase {
            synchronized(this) {
                var dbInstance = INSTANCE
                if (dbInstance == null) {
                    dbInstance =
                        Room.databaseBuilder(context,AppDatabase::class.java,
                            "parking_db").build()
                    INSTANCE = dbInstance
                }
                return dbInstance
            }
        }
    }
}