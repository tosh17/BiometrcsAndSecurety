package ru.thstdio.biometrcsandsecurety.ui.sharepreferences.presenter

import androidx.lifecycle.ViewModel
import ru.thstdio.biometrcsandsecurety.ui.sharepreferences.ui.SharedPreferencesView

class SharedPreferencesPresenter : ViewModel() {
    var isSaveMode = true
    val sharedPreferences by lazy { MySharedPreferences() }
    lateinit var viewState: SharedPreferencesView
    fun clickBtn(key: String, value: String) {
        if (isSaveMode) sharedPreferences.save(key, value)
        else viewState.setValue(sharedPreferences.load(key))
    }

    fun checkSwitch(check: Boolean) {
        isSaveMode = check
        viewState.setMode(isSaveMode)
    }

    fun setView(view: SharedPreferencesView) {
        viewState = view
    }


}