package com.example.nona_abstrak.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.nona_abstrak.Home.pertemuan2.SecondActivity
import com.example.nona_abstrak.databinding.FragmentHomeBinding
import com.example.nona_abstrak.pertemuan5.FifthActivity
import com.example.nona_abstrak.pertemuan6.AuthActivity
import com.example.nona_abstrak.pertemuan5.WebViewActivity
// IMPORT BARU (Pastikan nama package sesuai dengan folder tugasmu)
import com.example.nona_abstrak.tugaspertemuan3.LoginActivityTugas3
import com.example.nona_abstrak.tugasPertemuan4.HalamanUtama

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnWebView.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java))
        }
        // Setup Toolbar
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Portal Regulasi Desa"
            subtitle = "Bina Desa - Sistem Informasi"
        }
        // --- TOMBOL NAVIGASI PERTEMUAN ---

        // Pertemuan 2
        binding.btnToSecond.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }
        // Pertemuan 3 (LOGIN TUGAS 3)
        binding.btnToThird.setOnClickListener {
            startActivity(Intent(requireContext(), LoginActivityTugas3::class.java))
        }
        // Pertemuan 4 (HALAMAN UTAMA TUGAS 4)
        binding.btnToFourth.setOnClickListener {
            startActivity(Intent(requireContext(), HalamanUtama::class.java))
        }
        // Pertemuan 5
        binding.btnToFifth.setOnClickListener {
            startActivity(Intent(requireContext(), FifthActivity::class.java))
        }
        // --- LOGOUT ---
        binding.btnLogout.setOnClickListener {
            val sharedPref = requireContext().getSharedPreferences("RegulasiDesaPref", AppCompatActivity.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.clear()
            editor.apply()
            // Kembali ke AuthActivity
            startActivity(Intent(requireContext(), AuthActivity::class.java))
            requireActivity().finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}