package com.example.passwordmanager.di

import android.content.Context
import androidx.room.Room
import com.example.passwordmanager.room.dao.PasswordDao
import com.example.passwordmanager.room.database.PasswordManagerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun providesAppDataBase(@ApplicationContext context: Context): PasswordManagerDatabase =
        Room.databaseBuilder(
            context = context,
            klass = PasswordManagerDatabase::class.java,
            name = "password_database"
        )
            .fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun providePasswordLocalDao(passwordDatabase: PasswordManagerDatabase): PasswordDao =
        passwordDatabase.passwordDao()


}