package ru.thstdio.biometrcsandsecurety.ui.tink.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.tink_fragment.view.*
import org.koin.android.viewmodel.ext.android.viewModel
import ru.thstdio.biometrcsandsecurety.R
import ru.thstdio.biometrcsandsecurety.ui.tink.presenter.TinkPresenter

class TinkFragment : Fragment(), TinkView {
    val presenter: TinkPresenter by viewModel()
    lateinit var mView: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mView = inflater.inflate(R.layout.tink_fragment, null)
        presenter.setView(this)
       mView.tink_edit.doOnTextChanged { text, _, _, _ ->
            presenter.encrypt(text.toString())
        }
        mView.tink_encode_aad.doOnTextChanged { text, _, _, _ ->
            presenter.setAadEncode(text.toString())
        }
        mView.thik_decode_aad.doOnTextChanged { text, _, _, _ ->
            presenter.setAadDecode(text.toString())
        }
        return mView
    }

    override fun setEncrypt(encrypt: String) {
        mView.tink_encode_result.setText(encrypt)
    }

    override fun setDecrypter(decrypt: String) {
        mView.tink_decode_result.setText(decrypt)
    }
}