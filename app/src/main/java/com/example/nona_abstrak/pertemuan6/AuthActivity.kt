package com.example.nona_abstrak.pertemuan6

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nona_abstrak.BaseActivity
import com.example.nona_abstrak.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("RegulasiDesaPref", MODE_PRIVATE)

        // Tombol ke Register
        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username dan password wajib diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Ambil data dari SharedPreferences
            val regUsername = sharedPref.getString("reg_username", "") ?: ""
            val regPassword = sharedPref.getString("reg_password", "") ?: ""

            val bolehLogin = when {
                // Rule 1: username == password
                username == password -> true
                // Rule 2: username & password sesuai data registrasi
                username == regUsername && password == regPassword -> true
                else -> false
            }

            if (bolehLogin) {
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username", username)
                editor.apply()

                startActivity(Intent(this, BaseActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Username atau password salah!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}