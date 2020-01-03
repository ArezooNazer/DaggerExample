package com.arezoonazer.daggerexample.di.module

import com.arezoonazer.daggerexample.data.remote.Apis
import com.arezoonazer.daggerexample.data.repository.HomeRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideHomeRepository(apis: Apis): HomeRepository = HomeRepository.getHomeReposInstance(apis)
}