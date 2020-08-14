package ru.thstdio.biometrcsandsecurety.securety

import android.os.Build
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader


fun checkRootMethod() = checkRootMethod1() || checkRootMethod2() || checkRootMethod3()
fun checkRootMethod1(): Boolean {
    var process: Process? = null
    return try {
        process = Runtime.getRuntime().exec(arrayOf("/system/xbin/which", "su"))
        val input = BufferedReader(InputStreamReader(process.inputStream))
        input.readLine() != null
    } catch (t: Throwable) {
        false
    } finally {
        process?.destroy()
    }
}


fun checkRootMethod2(): Boolean {
    val paths = listOf(
        "/system/app/Superuser.apk",
        "/sbin/su",
        "/system/bin/su",
        "/system/xbin/su",
        "/data/local/xbin/su",
        "/data/local/bin/su",
        "/system/sd/xbin/su",
        "/system/bin/failsafe/su",
        "/data/local/su",
        "/su/din/su"
    )
    return paths.any { path -> File(path).exists() }
}

fun checkRootMethod3(): Boolean {
    val buildTags = Build.TAGS
    return buildTags != null && buildTags.contains("test-keys")
}

fun isRunningOnEmulator(): Boolean {
    val buildDetails =
        (Build.FINGERPRINT + Build.DEVICE + Build.MODEL +
                Build.BRAND + Build.PRODUCT + Build.MANUFACTURER +
                Build.HARDWARE).toLowerCase()
    return buildDetails.run {
        contains("generic")
                || contains("unknown")
                || contains("emulator")
                || contains("sdk")
                || contains("genymotion")
                || contains("x86")
                || contains("goldfish")
                || contains("test-key")
                || contains("google_sdk")
    }
}