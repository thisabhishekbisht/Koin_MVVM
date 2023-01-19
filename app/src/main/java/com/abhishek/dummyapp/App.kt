package com.abhishek.dummyapp

import android.app.Application
import com.mindorks.framework.mvvm.di.module.appModule
import com.mindorks.framework.mvvm.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

class App : Application() {
    companion object {
        lateinit var context: App
        val allAppModules = listOf(appModule, viewModelModule)
    }

    override fun onCreate() {
        super.onCreate()
        /*koin initialization*/
        context = this
        GlobalContext.startKoin {
            androidLogger()
            androidContext(this@App)
            modules(allAppModules)
        }
    }
}