package com.arezoonazer.daggerexample.data.remote

interface ApiResult<T> {
    fun onSuccess(result: T)
    fun onFailur(msg: String)
}