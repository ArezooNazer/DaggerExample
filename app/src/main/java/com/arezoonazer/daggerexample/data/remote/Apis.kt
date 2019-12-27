package com.arezoonazer.daggerexample.data.remote

import com.arezoonazer.daggerexample.data.model.Photo
import retrofit2.Call
import retrofit2.http.GET

interface Apis {

    @GET("photos")
    fun getPhotos(): Call<ArrayList<Photo>>
}