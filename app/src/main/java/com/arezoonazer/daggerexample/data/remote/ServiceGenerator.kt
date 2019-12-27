package com.arezoonazer.daggerexample.data.remote

import com.arezoonazer.daggerexample.presentation.util.AppConstant.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient


class ServiceGenerator {


    companion object {


        private var retrofit: Retrofit? = null
        private val sLock = Any()

        fun getRetrofitInstance(): Retrofit {

            if (retrofit == null) {
                synchronized(sLock) {
                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(makeInterceptor())
                        .build()
                }
            }

            return retrofit!!
        }

        private fun makeInterceptor(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder().addInterceptor(interceptor).build()
        }
    }
}