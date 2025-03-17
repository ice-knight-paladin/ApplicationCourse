package com.example.testaplacation

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.testaplacation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        binding.bottomNa.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.home -> navigateTo(FragmentHome())
                R.id.favo -> navigateTo(FragmentFavourites())
                R.id.personal -> navigateTo(FragmentPersonal())

                else -> {

                }
            }
            true
        }

    }


    private fun navigateTo(direction: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main, direction)
            .commit()
    }
}