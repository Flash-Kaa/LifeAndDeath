package com.flasska.word.data.di.binds

import com.flasska.word.data.CellsRepositoryImpl
import com.flasska.word.domain.interfaces.CellsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal abstract class CellRepositoryBindModule {
    @Binds
    @Singleton
    abstract fun bindCellRepository(repositoryImpl: CellsRepositoryImpl): CellsRepository
}