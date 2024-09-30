package com.flasska.word.data

import com.flasska.word.domain.entities.CellType
import com.flasska.word.domain.interfaces.CellsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CellsRepositoryImpl : CellsRepository {
    private val _cellsList: MutableStateFlow<List<CellType>> = MutableStateFlow(listOf())
    val cellsList = _cellsList.asStateFlow()

    override fun getCells(): Flow<List<CellType>> {
        return cellsList
    }

    override fun addCell(cell: CellType) {
        _cellsList.update { it + cell }
    }

    override fun changeCell(index: Int, newCellValue: CellType) {
        val changed = cellsList.value.mapIndexed { listIndex, cellType ->
            if (listIndex == index) {
                newCellValue
            } else {
                cellType
            }
        }

        _cellsList.update { changed }
    }
}