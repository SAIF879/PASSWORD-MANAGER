package com.example.passwordmanager.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.passwordmanager.room.dao.PasswordDao
import com.example.passwordmanager.room.model.PasswordDto


@Database(entities = [PasswordDto::class] , version = 2, exportSchema = false)
abstract  class PasswordManagerDatabase : RoomDatabase() {
abstract fun passwordDao() : PasswordDao
}
