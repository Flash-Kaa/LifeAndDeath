package com.flasska.word.presentation.utils

import android.content.Context
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.flasska.word.R
import com.flasska.word.domain.entities.CellType
import com.flasska.word.presentation.theme.DarkGreen
import com.flasska.word.presentation.theme.DarkPink
import com.flasska.word.presentation.theme.DarkYellow
import com.flasska.word.presentation.theme.LightGreen
import com.flasska.word.presentation.theme.LightPink
import com.flasska.word.presentation.theme.LightYellow

object CellTypeUtils {
    fun CellType.getName(context: Context): String {
        return when (this) {
            CellType.Alive -> context.getString(R.string.cell_alive)
            CellType.Death -> context.getString(R.string.cell_death)
            CellType.Life -> context.getString(R.string.cell_life)
        }
    }

    fun CellType.getEmoji(context: Context): String {
        return when (this) {
            CellType.Alive -> context.getString(R.string.cell_emoji_alive)
            CellType.Death -> context.getString(R.string.cell_emoji_death)
            CellType.Life -> context.getString(R.string.cell_emoji_life)
        }
    }

    fun CellType.getDescription(context: Context): String {
        return when (this) {
            CellType.Alive -> context.getString(R.string.cell_desc_alive)
            CellType.Death -> context.getString(R.string.cell_desc_death)
            CellType.Life -> context.getString(R.string.cell_desc_life)
        }
    }

    fun CellType.getBrush(): Brush {
        return Brush.verticalGradient(
            colors = listOf(
                getFirstBrushColor(),
                getSecondBrushColor()
            ),

        )
    }

    private fun CellType.getFirstBrushColor(): Color {
        return when (this) {
            CellType.Alive -> DarkYellow
            CellType.Death -> DarkGreen
            CellType.Life -> DarkPink

        }
    }

    private fun CellType.getSecondBrushColor(): Color {
        return when (this) {
            CellType.Alive -> LightYellow
            CellType.Death -> LightGreen
            CellType.Life -> LightPink
        }
    }
}