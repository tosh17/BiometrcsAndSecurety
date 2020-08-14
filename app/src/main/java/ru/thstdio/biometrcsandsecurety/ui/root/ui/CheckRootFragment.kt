package ru.thstdio.biometrcsandsecurety.ui.root.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.check_root_fragment.view.*
import org.koin.android.viewmodel.ext.android.viewModel
import ru.thstdio.biometrcsandsecurety.R
import ru.thstdio.biometrcsandsecurety.ui.root.presenter.CheckRootPresenter

class CheckRootFragment : Fragment(), CheckRootView {
    val presenter: CheckRootPresenter by viewModel()
    lateinit var mView: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mView = inflater.inflate(R.layout.check_root_fragment, null)
        presenter.setView(this)
        return mView
    }

    override fun setRootCheckResult(isRoot: Boolean) {
        setResult(mView.check_root_method_value, isRoot)
    }

    override fun setEmulatorMode(isEmulator: Boolean) {
        setResult(mView.check_emulator_value,isEmulator)
    }

    override fun setRootBeerisRoot(isRoot: Boolean) {
        setResult(mView.check_rootbeer_is_root_value,isRoot)
    }

    override fun isRootedWithBusyBoxCheck(isRoot: Boolean) {
        setResult(mView.check_rootbeer_isRootedWithBusyBoxCheck_value,isRoot)
    }

    override fun setDebugMode(isDebug: Boolean) {
        setResult(mView.check_debug_value,isDebug)
    }

    override fun setInstallerPackege(installerPackageName: String) {
       mView. installer_package_value.text=installerPackageName
    }

    fun setResult(view: TextView, result: Boolean) {
        view.run {
            text = result.toString()
            setTextColor(if (result) Color.GREEN else Color.RED)
        }
    }
}