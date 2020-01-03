package com.arezoonazer.daggerexample.di

import android.app.Application
import com.arezoonazer.daggerexample.presentation.MyDaggerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

/**
 * 1. Android apps has 1 Application class so we have 1 AppComponent & it's the root of graph
 * 2. AppComponent is responsible for application scope instances (db, retrofit, shared pref ...)
 * 3. for building DaggerAppComponent, you should add AndroidInjectionModule first (it's n internal module)
 */
@Component(
    modules = [AndroidInjectionModule::class]
)
interface AppComponent : AndroidInjector<MyDaggerApplication> {

    @Component.Builder
    interface Builder {
        /** we bind application here so all the modules can use this context also the component will
         * exist as long as application exist (bind to app lifecycle)*/
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

//    we don't need this any more bc we extend our component with Android injector
//    fun inject(app: MyDaggerApplication)

}