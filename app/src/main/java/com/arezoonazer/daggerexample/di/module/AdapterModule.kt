package com.arezoonazer.daggerexample.di.module

import com.arezoonazer.daggerexample.presentation.home.HomeAdapter
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {

    @Provides
    fun provideHomeAdapter(): HomeAdapter = HomeAdapter()
}