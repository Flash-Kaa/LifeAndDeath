package com.flasska.word.presentation.mainscreen

internal sealed class MainScreenAction {
    data object GenerateNewCell: MainScreenAction()
}