package com.flasska.word.presentation.mainscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.flasska.word.domain.entities.CellType
import com.flasska.word.presentation.theme.appComponent

@Composable
internal fun DrawerMainScreen() {
    val context = LocalContext.current
    val viewModel: MainScreenViewModel = viewModel(
        factory = context.appComponent
            .provideMainScreenViewModelFactoryWrapper()
            .InnerFactory()
    )

    val cells: List<CellType> by viewModel.cells.collectAsState(listOf())

    DrawerMainScreen(
        cells = cells,
        screenAction = viewModel::getAction
    )
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