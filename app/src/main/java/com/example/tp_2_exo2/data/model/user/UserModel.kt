package com.example.tp_2_exo2.data.model.user


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.tp_2_exo2.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserModel(private val userRepository: UserRepository): ViewModel() {

    val allUsers = mutableStateOf(listOf<User>())


    fun getAllUsers() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                allUsers.value  = userRepository.getAllUsers()
            }
        }
    }

    fun addUser(user: User) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                userRepository.addUser(user)
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