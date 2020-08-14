package ru.thstdio.biometrcsandsecurety.di

import org.koin.dsl.module
import ru.thstdio.biometrcsandsecurety.navigation.AppRouter

fun navModule() = module {
    single { AppRouter() }
}