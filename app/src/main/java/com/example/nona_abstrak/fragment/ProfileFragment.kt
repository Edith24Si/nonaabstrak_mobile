package com.example.nona_abstrak.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.nona_abstrak.databinding.FragmentProfileBinding
class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val dataListWithDesc = listOf(
        mapOf("title" to "Tentang Aplikasi",     "desc" to "Informasi tentang Portal Regulasi Desa"),
        mapOf("title" to "Kebijakan Privasi",     "desc" to "Cara kami melindungi data Anda"),
        mapOf("title" to "Syarat & Ketentuan",    "desc" to "Aturan penggunaan aplikasi"),
        mapOf("title" to "Versi Aplikasi",        "desc" to "v1.0.0 - Rilis Mei 2026"),
        mapOf("title" to "Hubungi Kami",          "desc" to "admin@regulasidesa.id"),
        mapOf("title" to "Panduan Pengguna",      "desc" to "Cara menggunakan fitur aplikasi"),
        mapOf("title" to "FAQ",                   "desc" to "Pertanyaan yang sering diajukan"),
        mapOf("title" to "Lisensi",               "desc" to "Open source libraries yang digunakan"),
        mapOf("title" to "Tim Pengembang",        "desc" to "Politeknik Caltex Riau - 2026"),
        mapOf("title" to "Laporkan Masalah",      "desc" to "Bantu kami meningkatkan kualitas app"),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Profil Pengembang"
        }
        // SimpleAdapter dengan simple_list_item_2
        val adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )
        binding.listViewItems.adapter = adapter

        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataListWithDesc[position]
            val title = selectedItem["title"]
            val desc = selectedItem["desc"]
            Toast.makeText(requireContext(), "$title: $desc", Toast.LENGTH_SHORT).show()
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}