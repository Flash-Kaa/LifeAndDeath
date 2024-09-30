package com.flasska.word.domain.usecases

import com.flasska.word.domain.entities.CellType
import com.flasska.word.domain.interfaces.CellsRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.random.Random

class GenerateCellsUseCase(
    private val repository: CellsRepository
) {
    private val coroutineScope = CoroutineScope(
        Dispatchers.IO + SupervisorJob() + CoroutineExceptionHandler { _, _ -> }
    )

    operator fun invoke() {
        coroutineScope.launch {
            val randomCellType = getRandomCell()

            val list = repository.cellsList.value + randomCellType
            repository.addCell(randomCellType)

            if (list.size < 3) {
                return@launch
            }

            if (needAddLife(list)) {
                repository.addCell(CellType.Life)
                return@launch
            }

            if (needChangeToDeath(list)) {
                changeLastLifeToDeath(list)
            }
        }
    }

    private fun getRandomCell(): CellType {
        val isDeath = Random.nextBoolean()
        return if (isDeath) CellType.Death else CellType.Alive
    }

    private fun needAddLife(list: List<CellType>) =
        list.takeLast(3)
            .all { it == CellType.Alive }

    private fun needChangeToDeath(list: List<CellType>): Boolean {
        val lastDeath = list.takeLastWhile { it == CellType.Death }.size

        return lastDeath > 0 && lastDeath % 3 == 0
    }

    private fun changeLastLifeToDeath(list: List<CellType>) {
        val lastLifeIndex = list.lastIndexOf(CellType.Life)

        if (lastLifeIndex >= 0) {
            repository.changeCell(lastLifeIndex, CellType.Death)
        }
    }
}