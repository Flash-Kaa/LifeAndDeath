package com.flasska.word.presentation.di

import android.content.Context
import com.flasska.word.presentation.MainActivity
import com.flasska.word.presentation.di.modules.MainViewModelFactoryWrapperModule
import com.flasska.word.presentation.mainscreen.MainScreenViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainViewModelFactoryWrapperModule::class])
internal interface AppComponent {
    fun inject(target: MainActivity)

    fun provideMainScreenViewModelFactoryWrapper(): MainScreenViewModel.FactoryWrapper

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}