package ru.thstdio.biometrcsandsecurety.ui.sharepreferences.presenter

import androidx.lifecycle.ViewModel

class SharedPreferencesPresenter : ViewModel() {
    val sharedPreferences by lazy { MySharedPreferences() }
}