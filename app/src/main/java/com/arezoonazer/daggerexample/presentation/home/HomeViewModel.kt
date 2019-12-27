package com.arezoonazer.daggerexample.presentation.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.arezoonazer.daggerexample.data.model.Photo
import com.arezoonazer.daggerexample.data.remote.ApiResult
import com.arezoonazer.daggerexample.data.repository.HomeRepository

class HomeViewModel(private val repository: HomeRepository): ViewModel() {
    val homeList = MutableLiveData<ArrayList<Photo>>()

    fun getHomeList() {
        repository.getHomeItems(object : ApiResult<ArrayList<Photo>> {
            override fun onSuccess(result: ArrayList<Photo>) {
                Log.d("HomeViewModel", "onSuccess ${result[0]}")
                homeList.value = result
            }

            override fun onFailur(msg: String) {
                Log.d("HomeViewModel", "get home failed with msg: $msg")
            }
        })
    }
}