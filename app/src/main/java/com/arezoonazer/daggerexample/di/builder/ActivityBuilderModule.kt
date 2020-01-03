package com.arezoonazer.daggerexample.di.builder

import com.arezoonazer.daggerexample.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * 1. We bind all our activities here & Dagger know our activities in compile time.
 * 2. All functions which uses '@ContributesAndroidInjector' should be abstract
 */

@Module(
    includes = [FragmentBuilderModule::class]
)
abstract class ActivityBuilderModule{

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}