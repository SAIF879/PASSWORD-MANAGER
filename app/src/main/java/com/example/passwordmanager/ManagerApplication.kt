package com.example.passwordmanager

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class ManagerApplication  : Application(){

    companion object{
        @JvmStatic
        var instance : ManagerApplication ? = null
        @JvmStatic
        fun getContext(): Context? {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance=this
    }
}

