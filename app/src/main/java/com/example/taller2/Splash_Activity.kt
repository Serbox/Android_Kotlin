package com.example.taller2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Splash_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        supportActionBar?.hide()

        lifecycleScope.launch {
            delay(2000) // Espera 2 segundos
            startActivity(Intent(this@Splash_Activity, MainActivity::class.java))
            finish()
        }
    }
}