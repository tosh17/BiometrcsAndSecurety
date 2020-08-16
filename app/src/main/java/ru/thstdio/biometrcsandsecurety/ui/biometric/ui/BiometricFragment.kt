package ru.thstdio.biometrcsandsecurety.ui.biometric.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.biometric_fragment.view.*
import ru.thstdio.biometrcsandsecurety.R

class BiometricFragment : Fragment() {
    val executor by lazy { ContextCompat.getMainExecutor(context) }
    val biometricManager by lazy { BiometricManager.from(requireContext()) }
    lateinit var mView: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.biometric_fragment, null)
        mView.biometric_auth_btn.setOnClickListener { authUser() }
        canAuthenticate()
        return mView
    }

    fun canAuthenticate() {
        when (biometricManager.canAuthenticate()) {
            BiometricManager.BIOMETRIC_SUCCESS -> {
                mView.biometric_auth_btn.isVisible = true
                setResultCanAuthenticate("BiometricManager.BIOMETRIC_SUCCESS", true)
            }
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE ->
                setResultCanAuthenticate("BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE")
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE ->
                setResultCanAuthenticate("BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE")
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED ->
                setResultCanAuthenticate("BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED")
        }
    }

    fun setResultCanAuthenticate(text: String, result: Boolean = false) {
        mView.biomeric_can_authenticate_value.run {
            this.text = text
            setTextColor(if (result) Color.GREEN else Color.RED)
        }
    }

    private fun authUser() {
        mView.run {
            biomeric_auth_result_title.isVisible = false
            biomeric_auth_result_value.isVisible = false
        }
        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle(getString(R.string.auth_title))
            .setSubtitle(getString(R.string.auth_subtitle))
            .setDescription(getString(R.string.auth_description))
            .setDeviceCredentialAllowed(true)
            .build()

        val biometricPrompt = BiometricPrompt(this, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(
                    result: BiometricPrompt.AuthenticationResult
                ) {
                    super.onAuthenticationSucceeded(result)
                    setAuthResult("onAuthenticationSucceeded", "Ok", false)
                }

                override fun onAuthenticationError(
                    errorCode: Int, errString: CharSequence
                ) {
                    super.onAuthenticationError(errorCode, errString)
                    setAuthResult("onAuthenticationError", errString.toString())
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    setAuthResult("onAuthenticationFailed", "Failed")
                }
            })
        biometricPrompt.authenticate(promptInfo)
    }

    fun setAuthResult(title: String, result: String, isError: Boolean = true) {
        mView.run {
            biomeric_auth_result_title.isVisible = true
            biomeric_auth_result_title.text = title
            biomeric_auth_result_value.isVisible = true
            biomeric_auth_result_value.text = result
            biomeric_auth_result_value.setTextColor(if (isError) Color.RED else Color.GREEN)
        }
    }
}