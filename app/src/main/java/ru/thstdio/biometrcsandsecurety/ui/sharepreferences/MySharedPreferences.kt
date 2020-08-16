package ru.thstdio.biometrcsandsecurety.ui.sharepreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import ru.thstdio.biometrcsandsecurety.ui.MyApp


class MySharedPreferences {
    val context: Context
        get() = MyApp.instance
    private val sharedPreferences: SharedPreferences by lazy {
        val masterKeyAlias = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()
        EncryptedSharedPreferences.create(
            context, "PreferencesSAT",
            masterKeyAlias,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    fun save(key: String, value: String) =
        sharedPreferences.edit()
            .putString(key, value)
            .apply()

    fun load(key: String) = sharedPreferences.getString(key, "")!!
    fun clearAll() {
        sharedPreferences.edit().clear().apply()
    }
}



