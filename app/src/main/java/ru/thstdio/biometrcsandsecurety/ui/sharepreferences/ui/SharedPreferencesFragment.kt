package ru.thstdio.biometrcsandsecurety.ui.sharepreferences.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.shared_preferences_fragment.view.*
import org.koin.android.viewmodel.ext.android.viewModel
import ru.thstdio.biometrcsandsecurety.R
import ru.thstdio.biometrcsandsecurety.ui.sharepreferences.presenter.SharedPreferencesPresenter

class SharedPreferencesFragment : Fragment(),SharedPreferencesView {
    val presenter: SharedPreferencesPresenter by viewModel()
    lateinit var mView: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mView = inflater.inflate(R.layout.shared_preferences_fragment, null)
        presenter.setView(this )
        initView(mView)
        return mView
    }

    private fun initView(mView: View) {
        mView.run {
            shared_pref_switch.setOnCheckedChangeListener { _, isCheck ->
                presenter.checkSwitch(isCheck)
            }
            shared_pref_btn.setOnClickListener {
                presenter.clickBtn(
                    key = shared_pref_key.text.toString(),
                    value = shared_pref_value.text.toString()
                )
            }
        }
    }

    override fun setValue(text: String) {
        mView.shared_pref_value.setText(text)
    }

    override fun setMode(saveMode: Boolean) {
        mView.run {
            shared_pref_switch.text=if(saveMode) "Save mode" else "Load mode"
            shared_pref_btn.text=if(saveMode) "Save" else "Load"
            shared_pref_value.isEnabled=saveMode
            shared_pref_value.setText("")
        }
    }
}