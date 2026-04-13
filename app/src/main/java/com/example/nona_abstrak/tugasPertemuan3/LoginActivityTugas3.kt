package com.example.nona_abstrak.tugaspertemuan3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nona_abstrak.databinding.ActivityLoginTugas3Binding

class LoginActivityTugas3 : AppCompatActivity() {
    private lateinit var binding: ActivityLoginTugas3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginTugas3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val judul=intent.getStringExtra("Judul_Halaman")
        val deskripsi=intent.getStringExtra("Description")
        binding.JudulHalaman.text="$judul"
        binding.Description.text="$deskripsi"
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, WelcomeActivityTugas3::class.java)
            startActivity(intent)
        }
    }
}