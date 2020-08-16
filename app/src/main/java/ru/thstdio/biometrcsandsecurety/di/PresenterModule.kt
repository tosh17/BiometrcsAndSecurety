package ru.thstdio.biometrcsandsecurety.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.thstdio.biometrcsandsecurety.ui.menu.presenter.MenuPresenter
import ru.thstdio.biometrcsandsecurety.ui.root.presenter.CheckRootPresenter
import ru.thstdio.biometrcsandsecurety.ui.sharepreferences.presenter.SharedPreferencesPresenter
import ru.thstdio.biometrcsandsecurety.ui.tink.presenter.TinkPresenter

fun presenterModule() = module {
    viewModel { MenuPresenter(get()) }
    viewModel { CheckRootPresenter() }
    viewModel { TinkPresenter() }
    viewModel { SharedPreferencesPresenter() }
}