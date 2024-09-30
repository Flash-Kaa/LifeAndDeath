package com.flasska.word.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.flasska.word.presentation.navigation.NavGraph
import com.flasska.word.presentation.theme.LifeAndDeathTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LifeAndDeathTheme {
                NavGraph()
            }
        }
    }
}