package com.example.splashscreent1

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.splashscreent1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var navReceiver: NavigateToNextReceiver? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.R) {
            this.window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            this.window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }

    override fun onStart() {
        super.onStart()
        startService(Intent(this, StartSplashService::class.java))

//        val intentFilter = IntentFilter().apply { addAction("NAVIGATE_NEXT_SCREEN") }
//        registerReceiver(navReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        navReceiver?.let { unregisterReceiver(navReceiver) }
    }
}