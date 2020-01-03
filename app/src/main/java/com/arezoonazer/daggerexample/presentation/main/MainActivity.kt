package com.arezoonazer.daggerexample.presentation.main

import android.os.Bundle
import android.support.v4.app.Fragment
import com.arezoonazer.daggerexample.R
import com.arezoonazer.daggerexample.presentation.home.HomeFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

//    @Inject lateinit var homeFragment: HomeFragment

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
