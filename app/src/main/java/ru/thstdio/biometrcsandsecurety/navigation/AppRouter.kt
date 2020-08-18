package ru.thstdio.biometrcsandsecurety.navigation

import androidx.navigation.NavController
import ru.thstdio.biometrcsandsecurety.R

class AppRouter {
    private lateinit var controller: NavController
    fun init(navController: NavController) {
        controller = navController
        controller.setGraph(R.navigation.navigation)
    }

    fun open(screen: AppScreen) {
        val screenId = when (screen) {
            AppScreen.CheckRootScreen -> R.id.checkRootFragment
            AppScreen.BiomentricScreen -> R.id.biometricFragment
            AppScreen.GoogleTinkScreen -> R.id.tinkFragment
            AppScreen.SharedPreferencesScreen -> R.id.sharedPreferencesFragment
        }
        controller.navigate(screenId)
    }

}