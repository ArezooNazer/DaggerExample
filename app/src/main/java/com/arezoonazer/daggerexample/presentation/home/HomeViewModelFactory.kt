package com.arezoonazer.daggerexample.presentation.home

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.arezoonazer.daggerexample.data.repository.HomeRepository

//todo: inject repo
class HomeViewModelFactory(private val repository: HomeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java))
            return HomeViewModel(repository) as T
        throw IllegalAccessException("Unknown ViewModel class: Add your new ViewModel into ViewModelFactory.class")
    }
}