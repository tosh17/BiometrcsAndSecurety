package ru.thstdio.biometrcsandsecurety.ui.menu.presenter

import androidx.lifecycle.ViewModel
import ru.thstdio.biometrcsandsecurety.navigation.AppRouter
import ru.thstdio.biometrcsandsecurety.navigation.AppScreen

class MenuPresenter(private val router:AppRouter) : ViewModel() {
    fun clickRootBtn() {
        router.open(AppScreen.CheckRootScreen)
    }

    fun clickBiometricBtn() {
        router.open(AppScreen.BiomentricScreen)
    }

     fun clickGoogleTinkBtn() {
        router.open(AppScreen.GoogleTinkScreen)
    }

    fun clickSharedPreferencesBtn() {
        router.open(AppScreen.SharedPreferencesScreen)
    }
}