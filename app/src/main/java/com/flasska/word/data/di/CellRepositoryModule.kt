package com.flasska.word.data.di

import com.flasska.word.data.CellsRepositoryImpl
import com.flasska.word.data.di.binds.CellRepositoryBindModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [CellRepositoryBindModule::class])
class CellRepositoryModule {
    @Provides
    @Singleton
    fun provideCellRepositoryImpl() = CellsRepositoryImpl()
}