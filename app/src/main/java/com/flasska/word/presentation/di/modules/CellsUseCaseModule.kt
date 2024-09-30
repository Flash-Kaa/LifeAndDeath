package com.flasska.word.presentation.di.modules

import com.flasska.word.data.di.CellRepositoryModule
import com.flasska.word.domain.interfaces.CellsRepository
import com.flasska.word.domain.usecases.GenerateCellsUseCase
import com.flasska.word.domain.usecases.GetListOfCellsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [CellRepositoryModule::class])
internal class CellsUseCaseModule {
    @Provides
    @Singleton
    fun provideGenerateCellUseCase(
        repository: CellsRepository
    ): GenerateCellsUseCase = GenerateCellsUseCase(repository)

    @Provides
    @Singleton
    fun provideGetListOfCellsUseCase(
        repository: CellsRepository
    ): GetListOfCellsUseCase = GetListOfCellsUseCase(repository)
}