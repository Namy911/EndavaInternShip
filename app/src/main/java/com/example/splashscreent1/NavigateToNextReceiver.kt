package com.example.splashscreent1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.util.Log
import com.example.splashscreent1.StartSplashService.Companion.FLAG_NEXT_SCREEN

class NavigateToNextReceiver : BroadcastReceiver() {
private val TAG = "NavigateToNextReceiver"

    override fun onReceive(context: Context, intent: Intent) {
        val result = intent.getBooleanExtra(FLAG_NEXT_SCREEN, false)

        if (result){
            val navIntent = Intent(context, SecondActivity::class.java).apply {
                addFlags(FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(navIntent)
        }
        else
            Log.d(TAG, "onReceive: Error NavigateToNextReceiver")
    }
}