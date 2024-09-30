package com.flasska.word.presentation.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.flasska.word.R
import com.flasska.word.domain.entities.CellType
import com.flasska.word.presentation.mainscreen.components.SettingColorToStatusBar
import com.flasska.word.presentation.mainscreen.components.CellDrawer
import com.flasska.word.presentation.theme.Indigo
import com.flasska.word.presentation.theme.LifeAndDeathTheme
import com.flasska.word.presentation.theme.Violet

@Composable
internal fun MainScreen(
    cells: List<CellType>,
    screenAction: (MainScreenAction) -> Unit
) {
    SettingColorToStatusBar()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(Indigo, Color.Black)
                )
            )
            .padding(16.dp)
    ) {
        Title()

        ListOfCells(
            modifier = Modifier.weight(1f),
            cells = cells
        )

        ButtonCreate(
            screenAction = screenAction
        )
    }
}

@Composable
private fun Title() {
    Text(
        text = stringResource(R.string.main_screen_title),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        fontSize = 20.sp,
        lineHeight = 28.sp
    )
}

@Composable
private fun ListOfCells(
    modifier: Modifier,
    cells: List<CellType>
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(cells) {
            CellDrawer(it)
            Spacer(Modifier.height(4.dp))
        }
    }
}

@Composable
private fun ButtonCreate(screenAction: (MainScreenAction) -> Unit) {
    Button(
        shape = RoundedCornerShape(4.dp),
        onClick = { screenAction(MainScreenAction.GenerateNewCell) },
        colors = ButtonDefaults.buttonColors(
            containerColor = Violet
        ),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.create_cell).uppercase(),
            fontSize = 14.sp
        )
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    LifeAndDeathTheme {
        MainScreen(
            cells = listOf(
                CellType.Life,
                CellType.Life,
                CellType.Death,
                CellType.Alive
            ),
            screenAction = {}
        )
    }
}