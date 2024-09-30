package com.flasska.word.presentation.mainscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.flasska.word.domain.entities.CellType
import com.flasska.word.presentation.utils.CellTypeUtils.getBrush
import com.flasska.word.presentation.utils.CellTypeUtils.getDescription
import com.flasska.word.presentation.utils.CellTypeUtils.getEmoji
import com.flasska.word.presentation.utils.CellTypeUtils.getName

@Composable
fun CellDrawer(cellType: CellType) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CellPicture(cellType)
        CellInfo(cellType)
    }
}

@Composable
private fun CellInfo(cellType: CellType) {
    Column(
        modifier = Modifier.padding(start = 16.dp)
    ) {
        Text(
            text = cellType.getName(LocalContext.current),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            lineHeight = 28.sp
        )

        Text(
            text = cellType.getDescription(LocalContext.current),
            fontSize = 14.sp,
            lineHeight = 20.sp
        )
    }
}

@Composable
private fun CellPicture(cellType: CellType) {
    Box(
        modifier = Modifier
            .background(
                brush = cellType.getBrush(),
                shape = CircleShape
            )
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = cellType.getEmoji(LocalContext.current),
            fontSize = 20.sp,
            lineHeight = 28.sp
        )
    }
}