package com.example.tp_2_exo2.data.model.user


import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.tp_2_exo2.data.model.auth.AuthState
import com.example.tp_2_exo2.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserModel(private val userRepository: UserRepository): ViewModel() {

    val allUsers = mutableStateOf(listOf<User>())
    private var _signupState = mutableStateOf(SignUpState())
    val signupState : State<SignUpState> = _signupState

    fun resetAuthState( ) {
        _signupState.value = SignUpState()
    }

    fun getAllUsers() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                allUsers.value  = userRepository.getAllUsers()
            }
        }
    }

    fun addUser(user: User) {
        viewModelScope.launch {
            _signupState.value = signupState.value.copy(isLoading = true)
            withContext(Dispatchers.IO) {
                try {
                    userRepository.addUser(user)
                    _signupState.value = signupState.value.copy(isLoading = false, responseMsg = "success")
                } catch (e:Exception) {
                    _signupState.value = signupState.value.copy(isLoading = false, responseMsg = "Error")
                    Log.e("addUser(signUp)", "Database operation failed", e)
                }
            }
        }
    }


    class Factory(private val userRepository: UserRepository) : ViewModelProvider.Factory {
//        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return UserModel(userRepository) as T
        }
    }
}