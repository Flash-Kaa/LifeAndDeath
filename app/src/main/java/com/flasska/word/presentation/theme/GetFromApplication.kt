package com.flasska.word.presentation.theme

import android.content.Context
import com.flasska.word.presentation.LifeAndDeathApp
import com.flasska.word.presentation.di.AppComponent

internal val Context.appComponent: AppComponent
    get() = when (this) {
        is LifeAndDeathApp -> this.appComponent
        else -> this.applicationContext.appComponent
    }