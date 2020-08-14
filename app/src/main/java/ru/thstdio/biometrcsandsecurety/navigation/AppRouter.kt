package ru.thstdio.biometrcsandsecurety.navigation

import androidx.navigation.NavController
import ru.thstdio.biometrcsandsecurety.R

class AppRouter {
    private lateinit var controller: NavController
    fun init(navController: NavController) {
        controller = navController
        controller.setGraph(R.navigation.navigation)}

}