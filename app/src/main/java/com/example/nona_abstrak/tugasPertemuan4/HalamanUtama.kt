package com.example.nona_abstrak.tugasPertemuan4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nona_abstrak.MainActivity
import com.example.nona_abstrak.R
import com.example.nona_abstrak.databinding.ActivityHalamanUtamaBinding
import com.example.nona_abstrak.databinding.ActivityLoginTugas3Binding
import com.example.nona_abstrak.tugaspertemuan3.LoginActivityTugas3
import com.example.nona_abstrak.tugaspertemuan3.WelcomeActivityTugas3
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HalamanUtama : AppCompatActivity() {

    private lateinit var binding: ActivityHalamanUtamaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityHalamanUtamaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.TombolBangunruang.setOnClickListener {

            val intent= Intent(this, MainActivity::class.java)
            intent.putExtra("Judul_Halaman","nonaabstrak")
            intent.putExtra("Description","Aplikasi ini akan selalu membantu")
            startActivity(intent)

        }
        binding.HalamanLogin.setOnClickListener {

            val intent= Intent(this, LoginActivityTugas3::class.java)
            intent.putExtra("Judul_Halaman","nonaabstrak")
            intent.putExtra("Description","Aplikasi ini akan selalu membantu")
            startActivity(intent)

        }
        binding.HalamanWelcome.setOnClickListener {

            val intent= Intent(this, WelcomeActivityTugas3::class.java)
            intent.putExtra("Judul_Halaman","nonaabstrak")
            intent.putExtra("Description","Aplikasi ini akan selalu membantu")
            startActivity(intent)

        }
        binding.HalamanLogOut.setOnClickListener {
            MaterialAlertDialogBuilder(this)
            .setTitle("Konfirmasi")
            .setMessage("Apakah Anda yakin ingin melanjutkan?")
            .setPositiveButton("Ya") { dialog, _ ->

                dialog.dismiss()
                Log.e("Info Dialog","Anda memilih Login!")

                val intent = Intent(this, LoginActivityTugas3::class.java)
                startActivity(intent)

            }
            .setNegativeButton("Batal") { dialog, _ ->
                dialog.dismiss()
                Log.e("Info Dialog","Logout dibatalkan")
            }
            .show()

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}