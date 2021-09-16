package com.example.splashscreent1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.splashscreent1.databinding.FragmentMainBinding
import com.example.splashscreent1.databinding.FragmentSpashScreenBinding

class SplashFragment : Fragment(R.layout.fragment_spash_screen) {

    private var _binding: FragmentSpashScreenBinding? = null
    private val binding get() = checkNotNull(_binding) {"binding isn't initialized"}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpashScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}