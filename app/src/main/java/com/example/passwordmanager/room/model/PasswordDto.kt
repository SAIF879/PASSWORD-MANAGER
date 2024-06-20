package com.example.passwordmanager.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "saved_password_table")
 data class PasswordDto(
    @PrimaryKey
    val accountName: String,
    val userCredential: String,
    val password: String,
)


