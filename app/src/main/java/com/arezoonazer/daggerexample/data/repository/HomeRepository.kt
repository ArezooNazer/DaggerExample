package com.arezoonazer.daggerexample.data.repository

import com.arezoonazer.daggerexample.data.model.Photo
import com.arezoonazer.daggerexample.data.remote.ApiResult
import com.arezoonazer.daggerexample.data.remote.Apis
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class HomeRepository @Inject constructor(private val apiService: Apis) {

    fun getHomeItems(callback: ApiResult<ArrayList<Photo>>) {
        apiService.getPhotos().enqueue(object : Callback<ArrayList<Photo>> {
            override fun onFailure(call: Call<ArrayList<Photo>>, t: Throwable) {
                callback.onFailur(t.message ?: t.localizedMessage)
            }
            override fun onResponse(
                call: Call<ArrayList<Photo>>,
                response: Response<ArrayList<Photo>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        callback.onSuccess(it)
                    }
                }
            }

        })
    }

    companion object {
        private var instance: HomeRepository? = null

        fun getHomeReposInstance(apiService: Apis): HomeRepository {
            if (instance == null) {
                instance = HomeRepository(apiService = apiService)
            }
            return instance!!
        }
    }
}