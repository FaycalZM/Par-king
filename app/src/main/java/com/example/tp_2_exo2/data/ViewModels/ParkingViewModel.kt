package com.example.tp_2_exo2.data.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.tp_2_exo2.data.model.ParkingData
import com.example.tp_2_exo2.repository.ParkingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class ParkingViewModel(private val parkingRepository: ParkingRepository): ViewModel(){

    private val _allParkingsResponse = MutableLiveData<Response<List<ParkingData>>>()

    val allParkingsResponse : LiveData<Response<List<ParkingData>>> get() = _allParkingsResponse

    fun getAllParkings(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = parkingRepository.getAllParkings()

                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        _allParkingsResponse.value = response
                    }
                    Log.d("ParkingViewModel", "fetching parkings success: ${response.body()}")
                }
            } catch (e: Exception) {
                Log.e("ParkingViewModel", "fetch parkings error", e)
            }
        }
    }

    class Factory(private val parkingRepository: ParkingRepository) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ParkingViewModel(parkingRepository) as T
        }
    }
}