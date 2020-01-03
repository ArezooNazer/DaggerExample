package com.arezoonazer.daggerexample.di.builder

import android.arch.lifecycle.ViewModel
import com.arezoonazer.daggerexample.data.repository.HomeRepository
import com.arezoonazer.daggerexample.di.qualifier.ViewModelKey
import com.arezoonazer.daggerexample.presentation.home.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ViewModelBuilder {

    @Provides
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindHomeViewModel(homeRepository: HomeRepository): ViewModel {
        return HomeViewModel(homeRepository)
    }
}