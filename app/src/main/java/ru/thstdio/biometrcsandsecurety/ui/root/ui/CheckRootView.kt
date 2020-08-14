package ru.thstdio.biometrcsandsecurety.ui.root.ui

interface CheckRootView {
    fun setRootCheckResult(isRoot: Boolean)
    fun setEmulatorMode(isEmulator: Boolean)
    fun setRootBeerisRoot(isRoot: Boolean)
    fun isRootedWithBusyBoxCheck(isRoot: Boolean)
    fun setDebugMode(isDebug: Boolean)
    fun setInstallerPackege(installerPackageName: String)

}