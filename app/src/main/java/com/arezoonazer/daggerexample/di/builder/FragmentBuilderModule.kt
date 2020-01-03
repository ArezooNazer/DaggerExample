package com.arezoonazer.daggerexample.di.builder

import com.arezoonazer.daggerexample.di.module.AdapterModule
import com.arezoonazer.daggerexample.presentation.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [AdapterModule::class]
)
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment
}