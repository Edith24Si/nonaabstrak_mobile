package com.example.nona_abstrak.pertemuan6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.nona_abstrak.BaseActivity
import com.example.nona_abstrak.R
import com.example.nona_abstrak.fragment.tutorial.TutorialMessageActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val sharedPref = getSharedPreferences("RegulasiDesaPref", MODE_PRIVATE)
        val isLogin = sharedPref.getBoolean("isLogin", false)

        lifecycleScope.launch {
            delay(2000)
            if (isLogin) {
                // Jika sudah login, langsung ke halaman utama
                startActivity(Intent(this@SplashScreenActivity, BaseActivity::class.java))
            } else {
                // Jika belum login, tampilkan Onboarding (Pertemuan 11)
                startActivity(Intent(this@SplashScreenActivity, TutorialMessageActivity::class.java))
            }
            finish()
        }
    }
}
