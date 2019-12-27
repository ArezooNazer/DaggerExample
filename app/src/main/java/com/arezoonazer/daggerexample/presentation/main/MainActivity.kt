package com.arezoonazer.daggerexample.presentation.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.arezoonazer.daggerexample.R
import com.arezoonazer.daggerexample.presentation.home.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToHomeFragment()
    }

    private fun goToHomeFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity_container, HomeFragment())
            .commit()
    }
}
