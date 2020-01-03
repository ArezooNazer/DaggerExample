package com.arezoonazer.daggerexample.di.builder

import android.arch.lifecycle.ViewModelProvider
import com.arezoonazer.daggerexample.data.repository.HomeRepository
import com.arezoonazer.daggerexample.di.module.RepositoryModule
import com.arezoonazer.daggerexample.presentation.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 *  This class binds viewModel Factory & all viewModel dependencies must be declare here
 */

@Module(
    includes = [
        ViewModelBuilder::class,
        RepositoryModule::class
    ]
)
abstract class ViewModelFactoryBuilder {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}