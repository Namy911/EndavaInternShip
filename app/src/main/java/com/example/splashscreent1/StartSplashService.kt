package com.example.splashscreent1

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.util.Log
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.supervisorScope
import java.lang.Exception

const val TAG = "StartSplashService"

class StartSplashService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        doWork()
//        return START_REDELIVER_INTENT
        return START_STICKY
    }

    private fun doWork(){
        Handler().apply {
            postDelayed(
                {
                    val intent = Intent("com.example.splashscreent1.NAVIGATE_NEXT_SCREEN")
                    intent.putExtra(FLAG_NEXT_SCREEN, true)
                    applicationContext.sendBroadcast(intent)
                }, 2000
            )
        }
        stopSelf()
    }

    companion object{
        const val FLAG_NEXT_SCREEN = "flag.next.screen"
    }
}