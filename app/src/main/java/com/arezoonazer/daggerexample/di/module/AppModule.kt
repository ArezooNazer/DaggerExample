package com.arezoonazer.daggerexample.di.module

import com.arezoonazer.daggerexample.data.remote.Apis
import com.arezoonazer.daggerexample.data.remote.ServiceGenerator
import com.arezoonazer.daggerexample.di.builder.ViewModelFactoryBuilder
import dagger.Module
import dagger.Provides

/**
 * 1. We provide retrofit, okhttp, persistence db, shared pref etc here.
 */

@Module(
    includes = [ViewModelFactoryBuilder::class]
)
class AppModule {

    @Provides
    fun apiProvider(): Apis {
        return ServiceGenerator.getRetrofitInstance().create(Apis::class.java)
    }
}