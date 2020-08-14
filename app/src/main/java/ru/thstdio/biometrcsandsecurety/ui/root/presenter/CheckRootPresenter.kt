package ru.thstdio.biometrcsandsecurety.ui.root.presenter

import android.os.Debug
import androidx.lifecycle.ViewModel
import com.scottyab.rootbeer.RootBeer
import ru.thstdio.biometrcsandsecurety.securety.checkRootMethod
import ru.thstdio.biometrcsandsecurety.securety.isRunningOnEmulator
import ru.thstdio.biometrcsandsecurety.ui.MyApp.Companion.instance
import ru.thstdio.biometrcsandsecurety.ui.root.ui.CheckRootView

class CheckRootPresenter() : ViewModel() {
    fun setView(view: CheckRootView) {
        view.setRootCheckResult(isRoot = checkRootMethod())
        view.setEmulatorMode(isEmulator= isRunningOnEmulator())
        view.setDebugMode(isDebug=Debug.isDebuggerConnected())
        val rootBeer=RootBeer(instance)
        view.setRootBeerisRoot(isRoot= rootBeer.isRooted)
        view.isRootedWithBusyBoxCheck(isRoot=rootBeer.isRootedWithBusyBoxCheck)

        view.setInstallerPackege( instance.packageManager.getInstallerPackageName(instance.packageName)?:"developer")
    }
}