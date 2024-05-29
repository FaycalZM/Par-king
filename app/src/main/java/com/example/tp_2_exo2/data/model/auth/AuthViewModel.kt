package com.example.tp_2_exo2.data.model.auth


import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tp_2_exo2.data.api.types.AuthRequest
import com.example.tp_2_exo2.data.api.types.AuthResponse
import com.example.tp_2_exo2.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.RequestBody
import retrofit2.Response

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {
    // signup response state
    private val _signupResponse = MutableLiveData<Response<AuthResponse>>()
    val signupResponse : LiveData<Response<AuthResponse>> get() = _signupResponse
    // signin response state
    private val _loginResponse = MutableLiveData<Response<AuthResponse>>()
    val loginResponse : LiveData<Response<AuthResponse>> get() = _loginResponse

    val loading = mutableStateOf(false)
    val error = mutableStateOf<String?>(null)

    fun signupUser(user: MutableMap<String,RequestBody>) {
        loading.value = true
        error.value = null

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = authRepository.registerUser(user)
                loading.value = false
                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        _signupResponse.value = response
                    }
                    Log.d("AuthViewModel", "Register user success: ${response.body()}")
                } else {
                    error.value = "Failed to register user: ${response.message()}"
                }
            } catch (e:Exception) {
                Log.e("AuthViewModel", "Register user error", e)
                error.value = "Failed to register user: ${e.message}"
            } finally {
                loading.value = false
            }
        }
    }

    fun loginUser(user: AuthRequest) {
        loading.value = true
        error.value = null

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = authRepository.loginUser(user)
                loading.value = false
                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        _loginResponse.value = response
                    }
                    Log.d("AuthViewModel", "Login user success: ${response.body()}")
                } else {
                    error.value = "Failed to login user: ${response.message()}"
                }
            } catch (e:Exception) {
                Log.e("AuthViewModel", "login user error", e)
                error.value = "Failed to login user: ${e.message}"
            } finally {
                loading.value = false
            }
        }
    }

    class Factory(private val authRepository: AuthRepository) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AuthViewModel(authRepository) as T
        }
    }
}