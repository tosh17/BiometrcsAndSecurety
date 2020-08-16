package ru.thstdio.biometrcsandsecurety.ui.menu.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.menu_fragment.view.*
import org.koin.android.viewmodel.ext.android.viewModel
import ru.thstdio.biometrcsandsecurety.R
import ru.thstdio.biometrcsandsecurety.ui.menu.presenter.MenuPresenter

class MenuFragment : Fragment() {
    val presenter: MenuPresenter by viewModel()
    lateinit var mView: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mView = inflater.inflate(R.layout.menu_fragment, null)
        initView(mView)
        return mView
    }

    private fun initView(view: View) {
        view.run {
            menu_btn_root.setOnClickListener { presenter.clickRootBtn() }
            menu_btn_biometric.setOnClickListener { presenter.clickBiometricBtn() }
            menu_btn_biometric2.setOnClickListener { presenter.clickBiometric2Btn() }
            menu_btn_google_tink.setOnClickListener { presenter.clickGoogleTinkBtn() }
            menu_btn_shared_preferences.setOnClickListener { presenter.clickSharedPreferencesBtn() }
        }
    }
}