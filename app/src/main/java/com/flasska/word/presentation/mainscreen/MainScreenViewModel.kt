package com.flasska.word.presentation.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.flasska.word.domain.usecases.GenerateCellsUseCase
import com.flasska.word.domain.usecases.GetListOfCellsUseCase


internal class MainScreenViewModel(
    getListOfCellsUseCase: GetListOfCellsUseCase,
    private val generateCellsUseCase: GenerateCellsUseCase
) : ViewModel() {
    val cells = getListOfCellsUseCase()

    fun getAction(actionType: MainScreenAction) {
        when (actionType) {
            MainScreenAction.GenerateNewCell -> generateCell()
        }
    }

    private fun generateCell() {
        generateCellsUseCase()
    }

    class FactoryWrapper(
        private val getListOfCellsUseCase: GetListOfCellsUseCase,
        private val generateCellsUseCase: GenerateCellsUseCase
    ) {
        inner class InnerFactory : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MainScreenViewModel(
                    getListOfCellsUseCase = getListOfCellsUseCase,
                    generateCellsUseCase = generateCellsUseCase
                ) as T
            }
        }
    }
}