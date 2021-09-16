package com.example.splashscreent1

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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