package com.flasska.word.domain.interfaces

import com.flasska.word.domain.entities.CellType
import kotlinx.coroutines.flow.StateFlow

interface CellsRepository {
    val cellsList: StateFlow<List<CellType>>

    fun addCell(cell: CellType)

    fun changeCell(index: Int, newCellValue: CellType)
}