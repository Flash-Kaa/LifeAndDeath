package com.flasska.word.domain.usecases

import com.flasska.word.domain.entities.CellType
import com.flasska.word.domain.interfaces.CellsRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch
import kotlin.random.Random

class AddRandomCellUseCase(
    private val repository: CellsRepository
) {
    private val coroutineScope = CoroutineScope(
        Dispatchers.IO + SupervisorJob() + CoroutineExceptionHandler { _, _ -> }
    )

    operator fun invoke() {
        coroutineScope.launch {
            val randomCellType = getRandomCell()

            val list = repository.getCells().last() + randomCellType
            repository.addCell(randomCellType)

            if (list.size < 3) {
                return@launch
            }

            val lasts = list.takeLast(3)

            if (needAddLife(lasts)) {
                repository.addCell(CellType.Life)
                return@launch
            }

            if (needChangeToDeath(lasts)) {
                changeLastLifeToDeath(list)
            }
        }
    }

    private fun getRandomCell(): CellType {
        val isAlive = Random.nextBoolean()

        if (isAlive) {
            return CellType.Alive
        }

        return CellType.Death
    }

    private fun needAddLife(lasts: List<CellType>) = lasts.all { it == CellType.Alive }

    private fun needChangeToDeath(lasts: List<CellType>) = lasts.all { it == CellType.Death }

    private fun changeLastLifeToDeath(list: List<CellType>) {
        val lastLifeIndex = list.lastIndexOf(CellType.Life)

        if (lastLifeIndex >= 0) {
            repository.changeCell(lastLifeIndex, CellType.Death)
        }
    }
}