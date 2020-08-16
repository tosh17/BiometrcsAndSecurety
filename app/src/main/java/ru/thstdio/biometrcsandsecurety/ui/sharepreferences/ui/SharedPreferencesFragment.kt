package ru.thstdio.biometrcsandsecurety.ui.sharepreferences.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.android.viewmodel.ext.android.viewModel
import ru.thstdio.biometrcsandsecurety.R
import ru.thstdio.biometrcsandsecurety.ui.menu.presenter.MenuPresenter
import ru.thstdio.biometrcsandsecurety.ui.sharepreferences.presenter.SharedPreferencesPresenter

class SharedPreferencesFragment : Fragment() {
    val presenter: SharedPreferencesPresenter by viewModel()
    lateinit var mView: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mView = inflater.inflate(R.layout.shared_preferences_fragment, null)
     //   initView(mView)
        return mView
    }
}