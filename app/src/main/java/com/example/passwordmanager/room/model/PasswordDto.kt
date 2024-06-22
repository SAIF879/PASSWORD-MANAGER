package com.example.passwordmanager.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID


@Entity(tableName = "saved_password_table")
data class PasswordDto(
    @PrimaryKey val id: UUID = UUID.randomUUID(),

    @ColumnInfo("account_name")
    val accountName: String ="",
    @ColumnInfo("user_credential")
    val userCredential: String,
    @ColumnInfo("password")
    val password: String,
)


