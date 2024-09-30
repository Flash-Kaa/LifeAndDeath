package com.flasska.word.presentation.mainscreen

import androidx.lifecycle.ViewModel
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
}