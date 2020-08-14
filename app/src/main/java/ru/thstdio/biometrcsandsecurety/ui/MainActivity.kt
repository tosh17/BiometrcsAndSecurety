package ru.thstdio.biometrcsandsecurety.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import org.koin.android.ext.android.inject
import ru.thstdio.biometrcsandsecurety.R
import ru.thstdio.biometrcsandsecurety.navigation.AppRouter


class MainActivity : AppCompatActivity() {
    private  val router : AppRouter by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        router.init(Navigation.findNavController(this, R.id.nav_host_fragment))
    }
}