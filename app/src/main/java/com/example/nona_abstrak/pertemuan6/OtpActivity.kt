package com.example.nona_abstrak.pertemuan6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nona_abstrak.databinding.ActivityOtpBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
class OtpActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOtpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.apply {
            title = "Verifikasi OTP"
            setDisplayHomeAsUpEnabled(true)
        }
        // Ambil data dari RegisterActivity
        val nama     = intent.getStringExtra("nama") ?: ""
        val noHp     = intent.getStringExtra("noHp") ?: ""
        val username = intent.getStringExtra("username") ?: ""
        val password = intent.getStringExtra("password") ?: ""
        // Tampilkan info
        binding.tvInfoOtp.text = "Kode OTP telah dikirim ke nomor: $noHp"
        binding.btnVerifikasi.setOnClickListener {
            val inputOtp = binding.etOtp.text.toString()

            if (inputOtp.isEmpty()) {
                // Tampilkan MaterialAlertDialog jika kosong
                MaterialAlertDialogBuilder(this)
                    .setTitle("Verifikasi Gagal")
                    .setMessage("Kode OTP tidak boleh kosong!")
                    .setPositiveButton("Coba Lagi") { dialog, _ -> dialog.dismiss() }
                    .show()
                return@setOnClickListener
            }
            if (inputOtp == noHp) {
                // OTP benar → simpan ke SharedPreferences (Soal 3)
                val sharedPref = getSharedPreferences("RegulasiDesaPref", MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("reg_nama",     nama)
                editor.putString("reg_noHp",     noHp)
                editor.putString("reg_username", username)
                editor.putString("reg_password", password)
                editor.apply()

                // Arahkan ke AuthActivity
                MaterialAlertDialogBuilder(this)
                    .setTitle("Registrasi Berhasil! 🎉")
                    .setMessage("Akun kamu berhasil dibuat. Silahkan login dengan username dan password yang sudah didaftarkan.")
                    .setPositiveButton("Login Sekarang") { _, _ ->
                        val intent = Intent(this, AuthActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                        startActivity(intent)
                        finish()
                    }
                    .show()
            } else {
                // OTP salah → tampilkan MaterialAlertDialog
                MaterialAlertDialogBuilder(this)
                    .setTitle("Verifikasi Gagal")
                    .setMessage("Kode OTP salah! Kode OTP adalah nomor handphone yang kamu daftarkan.")
                    .setPositiveButton("Coba Lagi") { dialog, _ -> dialog.dismiss() }
                    .show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}