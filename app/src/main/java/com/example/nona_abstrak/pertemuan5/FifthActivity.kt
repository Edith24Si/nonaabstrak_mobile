package com.example.nona_abstrak.pertemuan5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nona_abstrak.R

class FifthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        supportActionBar?.apply {
            title = "Pertemuan 5"
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}