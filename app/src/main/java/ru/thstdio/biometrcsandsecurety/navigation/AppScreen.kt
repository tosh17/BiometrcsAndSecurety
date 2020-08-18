package ru.thstdio.biometrcsandsecurety.navigation

sealed class AppScreen {
    object CheckRootScreen : AppScreen()
    object BiomentricScreen : AppScreen()
    object GoogleTinkScreen : AppScreen()
    object SharedPreferencesScreen : AppScreen()

}