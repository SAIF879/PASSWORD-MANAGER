package com.example.passwordmanager.mainflow.home.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.passwordmanager.room.model.PasswordDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val passwordRepository: HomeRepository
) : ViewModel() {

    private val _passwords = MutableStateFlow<List<PasswordDto>>(emptyList())
    val passwords: StateFlow<List<PasswordDto>> = _passwords

    init {
        fetchAllPasswords()
    }

    private fun fetchAllPasswords() {
        viewModelScope.launch {
            passwordRepository.getAllPasswords().collect { passwordsList ->
                _passwords.value = passwordsList
            }
        }
    }

    fun addPassword(passwordDto: PasswordDto) {
        viewModelScope.launch {
            passwordRepository.insertPassword(passwordDto)
            fetchAllPasswords()  // Refresh the list after insertion
        }
    }

    fun updatePassword(passwordDto: PasswordDto) {
        viewModelScope.launch {
            passwordRepository.updatePassword(passwordDto)
            fetchAllPasswords()  // Refresh the list after update
        }
    }

    fun deletePassword(passwordDto: PasswordDto) {
        viewModelScope.launch {
            passwordRepository.deletePassword(passwordDto)
            fetchAllPasswords()  // Refresh the list after deletion
        }
    }

    fun clearPasswords() {
        viewModelScope.launch {
            passwordRepository.clearAllPasswords()
            fetchAllPasswords()  // Refresh the list after clearing
        }
    }
}