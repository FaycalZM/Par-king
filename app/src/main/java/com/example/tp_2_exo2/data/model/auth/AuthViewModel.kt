package com.example.tp_2_exo2.data.model.auth

import android.util.Log
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.tp_2_exo2.data.model.user.User
import com.example.tp_2_exo2.data.model.user.UserModel
import com.example.tp_2_exo2.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthViewModel(private val userRepository: UserRepository) : ViewModel() {
    val userPassword = mutableStateOf("")

    private var _loginState = mutableStateOf(AuthState())
    val loginState : State<AuthState> = _loginState

    fun resetAuthState( ) {
        _loginState.value = AuthState()
    }
    fun signIn(email: String){
        viewModelScope.launch {
            _loginState.value = loginState.value.copy(isLoading = true)
            withContext(Dispatchers.IO) {
                try {
                    val user = userRepository.getUserByEmail(email)
                    withContext(Dispatchers.Main){
                        if (user != null) {
                            // user exists
                            _loginState.value = loginState.value.copy(isLoading = false, responseMsg = "User exists",activeUser = user)
                        } else { // user not found
                            _loginState.value = loginState.value.copy(isLoading = false,responseMsg = "User not found")
                        }
                    }
                } catch (e:Exception) {
                    Log.e("getUserByEmail(login)", "Database operation failed", e)
                }
            }
        }
    }



    class Factory(private val userRepository: UserRepository) : ViewModelProvider.Factory {
        //        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AuthViewModel(userRepository) as T
        }
    }
}