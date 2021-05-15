package com.s95ammar.roomdemo

import android.app.Application

class RoomDemoApplication : Application() {

    companion object {
        var instance: RoomDemoApplication? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }


}