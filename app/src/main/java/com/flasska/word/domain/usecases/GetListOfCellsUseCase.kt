package com.flasska.word.domain.usecases

import com.flasska.word.domain.interfaces.CellsRepository

class GetListOfCellsUseCase(
    private val repository: CellsRepository
) {
    operator fun invoke() = repository.getCells()
}