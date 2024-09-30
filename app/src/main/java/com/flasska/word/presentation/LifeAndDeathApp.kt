package com.flasska.word.presentation

import android.app.Application
import com.flasska.word.presentation.di.AppComponent
import com.flasska.word.presentation.di.DaggerAppComponent

internal class LifeAndDeathApp : Application() {
    lateinit var appComponent: AppComponent

    private fun initDagger(app: LifeAndDeathApp): AppComponent =
        DaggerAppComponent.builder()
            .context(app)
            .build()

    override fun onCreate() {
        super.onCreate()

        appComponent = initDagger(this)
    }
}