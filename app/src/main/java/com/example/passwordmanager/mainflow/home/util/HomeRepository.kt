package com.example.passwordmanager.mainflow.home.util

import android.util.Log
import com.example.passwordmanager.room.dao.PasswordDao
import com.example.passwordmanager.room.model.PasswordDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class HomeRepository @Inject constructor(
    private val passwordDao: PasswordDao
) {

    fun getAllPasswords(): Flow<List<PasswordDto>> = flow {
        try {
            emit(passwordDao.getAllPasswords())
        } catch (e: Exception) {

            emit(emptyList())
        }
    }

    suspend fun getPassword(accountName: String): PasswordDto? {
        return try {
            passwordDao.getPassword(accountName)
        } catch (e: Exception) {
            Log.e("DatabaseError", "Failed to get password for account: $accountName", e)
            null
        }
    }

    suspend fun insertPassword(passwordDto: PasswordDto) {
        try {
            passwordDao.insert(passwordDto)
        } catch (e: Exception) {
            Log.e("DatabaseError", "Error inserting password: ${e.localizedMessage}")
        }
    }

    suspend fun updatePassword(passwordDto: PasswordDto) {
        try {
            passwordDao.update(passwordDto)
            Log.d("HomeRepository", "Password updated in DB: $passwordDto")
        } catch (e: Exception) {
            Log.e("DatabaseError", "Error updating password: ${e.localizedMessage}")
        }
    }
    suspend fun deletePassword(passwordDto: PasswordDto) {
        try {
            passwordDao.delete(passwordDto)
        } catch (e: Exception) {
            Log.e("DatabaseError", "Error deleting password: ${e.localizedMessage}")
        }
    }

    suspend fun clearAllPasswords() {
        try {
            passwordDao.getAllPasswords().forEach { passwordDto ->
                passwordDao.delete(passwordDto)
            }
        } catch (e: Exception) {
            Log.e("DatabaseError", "Error clearing passwords: ${e.localizedMessage}")
        }
    }
}