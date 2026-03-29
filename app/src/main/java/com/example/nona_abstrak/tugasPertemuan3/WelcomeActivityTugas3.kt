package com.example.nona_abstrak.tugaspertemuan3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nona_abstrak.databinding.ActivityWelcomeTugas3Binding

class WelcomeActivityTugas3 : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeTugas3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeTugas3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKembali.setOnClickListener {
            finish()
        }
    }
}