package com.flasska.word.domain.interfaces

import com.flasska.word.domain.entities.CellType
import kotlinx.coroutines.flow.Flow

interface CellsRepository {
    fun getCells(): Flow<List<CellType>>

    fun addCell(cell: CellType)

    fun changeCell(index: Int, newCellValue: CellType)
}