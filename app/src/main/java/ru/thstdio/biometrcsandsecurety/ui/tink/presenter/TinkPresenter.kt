package ru.thstdio.biometrcsandsecurety.ui.tink.presenter

import androidx.lifecycle.ViewModel
import com.google.crypto.tink.Aead
import com.google.crypto.tink.KeysetHandle
import com.google.crypto.tink.aead.AeadKeyTemplates
import com.google.crypto.tink.aead.AesGcmKeyManager
import com.google.crypto.tink.config.TinkConfig
import ru.thstdio.biometrcsandsecurety.ui.tink.ui.TinkView
import java.lang.Exception
import java.util.*


class TinkPresenter : ViewModel() {

    lateinit var viewState: TinkView
    val aead: Aead by lazy {
        val keysetHandle = KeysetHandle.generateNew(AesGcmKeyManager.aes128GcmTemplate())
        keysetHandle.getPrimitive(Aead::class.java)
    }
    var addEncode="0000".toByteArray()
    var addDecode="0000".toByteArray()

    fun setView(view: TinkView) {
        viewState = view
        TinkConfig.register()
    }

    fun encrypt(text: String) {
        val bytes = text.toByteArray()
        val ciphertext = aead.encrypt(bytes, addEncode)
        viewState.setEncrypt(String(ciphertext))
        decrypt(ciphertext)
    }

    fun decrypt(bytes: ByteArray) {
        try {
            val decrypted = aead.decrypt(bytes, addDecode)
            viewState.setDecrypter(String(decrypted))
        } catch (e:Exception){
            viewState.setDecrypter("Error decrypted")
        }

    }

    fun setAadEncode(add: String) {
        addEncode=add.toByteArray()
    }

    fun setAadDecode(add: String) {

        addDecode=add.toByteArray()
    }
}