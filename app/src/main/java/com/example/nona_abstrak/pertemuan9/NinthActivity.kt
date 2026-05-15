package com.example.nona_abstrak.pertemuan9

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nona_abstrak.databinding.ActivityNinthBinding
import com.example.nona_abstrak.pertemuan_9.MessageAdapter
import com.example.nona_abstrak.pertemuan_9.MessageModel
import com.google.android.material.chip.Chip

class NinthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNinthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNinthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Setup Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 9"
            setDisplayHomeAsUpEnabled(true)
        }

        // 2. Event Klik Login (TextInputLayout & MaterialButton)
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            if (email.isEmpty()) {
                // Menampilkan error di TextInputLayout
                binding.textInputLayout.error = "Email tidak boleh kosong!"
                binding.textInputLayout.requestFocus()
            } else {
                binding.textInputLayout.error = null
                Toast.makeText(this, "Login berhasil: $email", Toast.LENGTH_SHORT).show()
            }
        }

        // 3. Event ChipGroup (Filter)
        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull()
            if (selectedChipId != null) {
                val chip = group.findViewById<Chip>(selectedChipId)
                Toast.makeText(this, "Filter aktif: ${chip.text}", Toast.LENGTH_SHORT).show()
            }
        }

        // 4. Custom ListView (Data Model & Adapter)
        val messageList = listOf(
            MessageModel("Sekretaris Desa", "Draft Perdes No. 4 tentang Pengelolaan Sampah sudah saya upload.", "https://avatar.iran.liara.run/public/1"),
            MessageModel("Kepala Dusun 1", "Warga menanyakan salinan regulasi penggunaan dana desa tahun ini.", "https://avatar.iran.liara.run/public/2"),
            MessageModel("Admin Sistem", "Pemberitahuan: Sistem Produk Hukum akan maintenance malam ini.", "https://avatar.iran.liara.run/public/3")
        )

        val adapter = MessageAdapter(this, messageList)
        binding.listViewMessages.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}