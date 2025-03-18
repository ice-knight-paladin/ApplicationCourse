package com.example.testaplacation

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.testaplacation.BD.Core
import com.example.testaplacation.BD.Repository
import com.example.testaplacation.databinding.ActivityMainBinding
import com.example.testaplacation.models.Cash
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var cashBase: Repository.CashBase



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        CoroutineScope(Dispatchers.IO).launch {
            cashBase = Repository.CashBase(Core(this@MainActivity).cashDao())
            //TEST
            //cashBase.delete(cashBase.courseList()[0])
            if (cashBase.courseList().isEmpty()){
                cashBase.add(Cash(0, "not first"))
                startActivity(Intent(this@MainActivity, StartActivity::class.java))
                finish()
            }else{
                navigateTo(FragmentHome())
            }
        }

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