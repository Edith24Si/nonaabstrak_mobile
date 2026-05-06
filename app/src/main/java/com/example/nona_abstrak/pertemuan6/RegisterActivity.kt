package com.example.nona_abstrak.pertemuan6

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nona_abstrak.databinding.ActivityRegisterBinding
import kotlin.jvm.java
class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.apply {
            title = "Registrasi"
            setDisplayHomeAsUpEnabled(true)
        }
        binding.btnRegister.setOnClickListener {
            val nama     = binding.etNama.text.toString()
            val noHp     = binding.etNoHp.text.toString()
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (nama.isEmpty() || noHp.isEmpty() || username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Semua field wajib diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // Kirim data ke OtpActivity
            val intent = Intent(this, OtpActivity::class.java).apply {
                putExtra("nama",     nama)
                putExtra("noHp",     noHp)
                putExtra("username", username)
                putExtra("password", password)
            }
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}