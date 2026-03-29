package com.example.nona_abstrak
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etPanjang = findViewById<EditText>(R.id.etPanjang)
        val etLebar = findViewById<EditText>(R.id.etLebar)
        val etTinggi = findViewById<EditText>(R.id.etTinggi)
        val btnHitungLuas = findViewById<Button>(R.id.btnHitungLuas)
        val btnHitungVolume = findViewById<Button>(R.id.btnHitungVolume)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        // 2. Memberikan aksi ketika Tombol Hitung Luas diklik
        btnHitungLuas.setOnClickListener {
            val inputPanjang = etPanjang.text.toString()
            val inputLebar = etLebar.text.toString()

            // Memastikan input tidak kosong
            if (inputPanjang.isNotEmpty() && inputLebar.isNotEmpty()) {
                val panjang = inputPanjang.toDouble()
                val lebar = inputLebar.toDouble()

                // Rumus Luas Persegi Panjang: P x L
                val luas = panjang * lebar

                tvHasil.text = "Luas Persegi Panjang: $luas"
                Log.d("Kalkulasi", "Luas berhasil dihitung: $luas") // Contoh penggunaan Logcat
            } else {
                Toast.makeText(this, "Panjang dan Lebar harus diisi!", Toast.LENGTH_SHORT).show()
            }
        }

        // 3. Memberikan aksi ketika Tombol Hitung Volume diklik
        btnHitungVolume.setOnClickListener {
            val inputPanjang = etPanjang.text.toString()
            val inputLebar = etLebar.text.toString()
            val inputTinggi = etTinggi.text.toString()

            // Memastikan input tidak kosong
            if (inputPanjang.isNotEmpty() && inputLebar.isNotEmpty()
                && inputTinggi.isNotEmpty()) {
                val panjang = inputPanjang.toDouble()
                val lebar = inputLebar.toDouble()
                val tinggi = inputTinggi.toDouble()

                // Rumus Volume Balok: P x L x T
                val volume = panjang * lebar * tinggi

                tvHasil.text = "Volume Balok: $volume"
                Log.d("Kalkulasi", "Volume berhasil dihitung: " +
                        "$volume") // Contoh penggunaan Logcat
            } else {
                Toast.makeText(this, "Panjang, Lebar, " +
                        "dan Tinggi harus diisi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}