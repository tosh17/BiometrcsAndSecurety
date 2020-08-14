package ru.thstdio.biometrcsandsecurety.ui

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.thstdio.biometrcsandsecurety.BuildConfig
import ru.thstdio.biometrcsandsecurety.di.navModule
import ru.thstdio.biometrcsandsecurety.di.presenterModule
import timber.log.Timber

class MyApp : Application() {
    companion object{
        lateinit var instance:MyApp
    }
    override fun onCreate() {
        super.onCreate()
        instance=this
        initTimber()
        initKoin ()
    }
    private fun initKoin() {
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(presenterModule(), navModule()))
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}