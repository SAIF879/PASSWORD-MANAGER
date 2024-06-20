package com.example.passwordmanager.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.passwordmanager.room.model.PasswordDto

@Dao
interface PasswordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(passwordDto: PasswordDto)

    @Update
    suspend fun update(passwordDto: PasswordDto)

    @Delete
    suspend fun delete(passwordDto: PasswordDto)

    @Query("SELECT * FROM saved_password_table WHERE accountName = :accountName")
    suspend fun getPassword(accountName: String): PasswordDto?

    @Query("SELECT * FROM saved_password_table")
    suspend fun getAllPasswords(): List<PasswordDto>

}