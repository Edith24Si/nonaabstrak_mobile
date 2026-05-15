package com.example.nona_abstrak.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.nona_abstrak.databinding.FragmentMoreBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MoreFragment : Fragment() {
    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    private val dataListWithDesc = listOf(
        mapOf("title" to "Tentang Program Bina Desa",  "desc" to "Informasi tentang program"),
        mapOf("title" to "Kebijakan Privasi",          "desc" to "Data pengguna dilindungi"),
        mapOf("title" to "Syarat dan Ketentuan",       "desc" to "Aturan penggunaan aplikasi"),
        mapOf("title" to "Bantuan",                    "desc" to "Hubungi kami"),
        mapOf("title" to "Versi Aplikasi v1.0",        "desc" to "Rilis Mei 2026"),
    )

    private val menuDescriptions = listOf(
        "Program ini bertujuan untuk membantu digitalisasi administrasi desa agar pelayanan masyarakat menjadi lebih cepat dan modern.",
        "Data pengguna dijaga dengan aman dan tidak dibagikan kepada pihak lain tanpa izin.",
        "Dengan menggunakan aplikasi ini, Anda menyetujui syarat dan ketentuan yang berlaku.",
        "Hubungi kami di admin@regulasidesa.id untuk bantuan lebih lanjut.",
        "Aplikasi Bina Desa versi 1.0.0 - Dikembangkan oleh Politeknik Caltex Riau 2026."
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "More"
        }

        val adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        binding.listViewItems.adapter = adapter

        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(dataListWithDesc[position]["title"])
                .setMessage(menuDescriptions[position])
                .setPositiveButton("Tutup") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}