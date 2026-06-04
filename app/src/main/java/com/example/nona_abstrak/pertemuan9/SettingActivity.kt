package com.example.nona_abstrak.pertemuan_9

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.nona_abstrak.databinding.ActivitySettingBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding
    private val menuItems = listOf(
        "Tentang Program Bina Desa",
        "Kebijakan Privasi",
        "Syarat dan Ketentuan",
        "Bantuan",
        "Versi Aplikasi v1.0"
    )
    private val menuDescriptions = listOf(
        "Program ini bertujuan untuk membantu digitalisasi administrasi desa agar pelayanan masyarakat menjadi lebih cepat dan modern.",
        "Data pengguna dijaga dengan aman dan tidak dibagikan kepada pihak lain tanpa izin.",
        "Dengan menggunakan aplikasi ini, Anda menyetujui syarat dan ketentuan yang berlaku.",
        "Hubungi kami di admin@regulasidesa.id untuk bantuan lebih lanjut.",
        "Aplikasi Bina Desa versi 1.0.0 - Dikembangkan oleh Politeknik Caltex Riau 2026."
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Tentang Aplikasi"
            setDisplayHomeAsUpEnabled(true)
        }
        // ArrayAdapter
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            menuItems
        )
        binding.listViewSetting.adapter = adapter

        // OnClick tiap item
        binding.listViewSetting.setOnItemClickListener { _, _, position, _ ->
            MaterialAlertDialogBuilder(this)
                .setTitle(menuItems[position])
                .setMessage(menuDescriptions[position])
                .setPositiveButton("Tutup") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}