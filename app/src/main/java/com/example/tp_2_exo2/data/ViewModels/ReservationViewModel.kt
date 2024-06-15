package com.example.tp_2_exo2.data.ViewModels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tp_2_exo2.data.api.types.ReservationRequest
import com.example.tp_2_exo2.data.api.types.ReservationResponse
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

    private val _reservationResponse = MutableLiveData<Response<ReservationResponse>>()
    val reservationResponse : LiveData<Response<ReservationResponse>> get() = _reservationResponse

    val loading = mutableStateOf(false)
    val error = mutableStateOf<String?>(null)
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

    fun createReservation(reservation: ReservationRequest) {
        loading.value = true
        error.value = null

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = reservationRepository.createReservation(reservation)
                loading.value = false
                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        _reservationResponse.value = response
                    }
                    Log.d("ReservationViewModel", "reservation created successfully: ${response.body()}")
                } else {
                    error.value = "Failed to create reservation: ${response.message()}"
                }
            } catch (e:Exception) {
                Log.e("ReservationViewModel", "user reservation error", e)
                error.value = "Failed to create reservation: ${e.message}"
            } finally {
                loading.value = false
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