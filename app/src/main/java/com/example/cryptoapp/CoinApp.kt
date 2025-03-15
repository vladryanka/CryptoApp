package com.example.cryptoapp

import android.app.Application
import androidx.work.Configuration
import com.example.cryptoapp.data.worker.RefreshDataWorkerFactory
import com.example.cryptoapp.di.DaggerApplicationComponent
import javax.inject.Inject


class CoinApp : Application(), Configuration.Provider {

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

    @Inject
    lateinit var workerFactory: RefreshDataWorkerFactory
    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(
                workerFactory
            )
            .build()
}