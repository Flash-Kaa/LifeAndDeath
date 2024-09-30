package com.flasska.word.presentation.mainscreen

import androidx.compose.runtime.Composable
import com.flasska.word.domain.entities.CellType

@Composable
internal fun DrawerMainScreen() {

}

@Composable
private fun DrawerMainScreen(
    cells: List<CellType>,
    screenAction: (MainScreenAction) -> Unit
) {
    MainScreen(
        cells = cells,
        screenAction = screenAction
    )
}