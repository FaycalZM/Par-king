package com.example.tp_2_exo2.data.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tp_2_exo2.data.model.ReservationData
import com.example.tp_2_exo2.repository.ParkingRepository
import com.example.tp_2_exo2.repository.ReservationRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class ReservationViewModel
    (private val reservationRepository: ReservationRepository): ViewModel()
{
    private val _userReservations = MutableLiveData<Response<List<ReservationData>>>()
    val userReservations: LiveData<Response<List<ReservationData>>> get() = _userReservations

    fun getUserReservations(userId : String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = reservationRepository.getUserReservations(userId)

                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        _userReservations.value = response
                    }
                    Log.d("ReservationViewModel", "fetching reservations success: ${response.body()}")
                }
            } catch (e: Exception) {
                Log.e("ReservationViewModel", "fetch reservations error", e)
            }
        }
    }

    class Factory(private val reservationRepository: ReservationRepository) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ReservationViewModel(reservationRepository) as T
        }
    }
}