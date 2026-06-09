package com.example.nona_abstrak.pertemuan9

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nona_abstrak.R

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        
        supportActionBar?.title = "Pengaturan"
    }
}
