package com.flasska.word.presentation.di.modules

import com.flasska.word.domain.usecases.GenerateCellsUseCase
import com.flasska.word.domain.usecases.GetListOfCellsUseCase
import com.flasska.word.presentation.mainscreen.MainScreenViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [CellsUseCaseModule::class])
internal class MainViewModelFactoryWrapperModule {
    @Provides
    @Singleton
    fun provideMainViewModelFactoryWrapper(
        getListOfCellsUseCase: GetListOfCellsUseCase,
        generateCellsUseCase: GenerateCellsUseCase
    ): MainScreenViewModel.FactoryWrapper = MainScreenViewModel.FactoryWrapper(
        getListOfCellsUseCase = getListOfCellsUseCase,
        generateCellsUseCase = generateCellsUseCase
    )
}