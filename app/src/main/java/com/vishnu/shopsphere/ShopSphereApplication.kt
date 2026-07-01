package com.vishnu.shopsphere

import android.app.Application
import com.vishnu.shopsphere.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ShopSphereApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ShopSphereApplication)

            modules(appModule)
        }
    }
}