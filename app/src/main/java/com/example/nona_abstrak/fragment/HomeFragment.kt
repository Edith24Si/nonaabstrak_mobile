package com.example.nona_abstrak.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nona_abstrak.data.api.CatFactApiClient
import com.example.nona_abstrak.data.api.PhotoApiClient
import com.example.nona_abstrak.databinding.FragmentHomeBinding
import com.example.nona_abstrak.pertemuan5.WebViewActivity
import com.example.nona_abstrak.pertemuan6.AuthActivity
import com.example.nona_abstrak.pertemuan_9.SettingActivity
import com.example.nona_abstrak.pertemuan10.TenthActivity
import com.example.nona_abstrak.photo.PhotoAdapter
import com.google.android.material.chip.Chip
import kotlinx.coroutines.launch

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
        
        // Toolbar setup
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Bina Desa Digital"
        }

        // ChipGroup Logic
        binding.chipGroupKategori.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull()
            if (selectedChipId != null) {
                val chip = group.findViewById<Chip>(selectedChipId)
                Toast.makeText(requireContext(), "Kategori: ${chip.text}", Toast.LENGTH_SHORT).show()
            }
        }

        // Button Click Listeners
        binding.btnBumdes.setOnClickListener { Toast.makeText(requireContext(), "Menu Bumdes", Toast.LENGTH_SHORT).show() }
        binding.btnProfil.setOnClickListener { Toast.makeText(requireContext(), "Profil Desa", Toast.LENGTH_SHORT).show() }
        binding.btnForum.setOnClickListener { Toast.makeText(requireContext(), "Forum Warga", Toast.LENGTH_SHORT).show() }
        binding.btnWebView.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java))
        }
        binding.btnPertemuan10.setOnClickListener {
            startActivity(Intent(requireContext(), TenthActivity::class.java))
        }

        binding.btnTentangAplikasi.setOnClickListener {
            startActivity(Intent(requireContext(), SettingActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            val sharedPref = requireContext().getSharedPreferences("RegulasiDesaPref", AppCompatActivity.MODE_PRIVATE)
            sharedPref.edit().clear().apply()
            startActivity(Intent(requireContext(), AuthActivity::class.java))
            requireActivity().finish()
        }

        // Meeting 11 - Cat Fact API
        loadCatFact()
        binding.btnRefresh.setOnClickListener {
            loadCatFact()
        }

        // Meeting 11 - Photo Gallery API
        loadPhotos()
    }

    private fun loadCatFact() {
        binding.tvCatFact.text = "Mengambil fakta..."
        lifecycleScope.launch {
            try {
                val response = CatFactApiClient.apiService.getCatFact()
                binding.tvCatFact.text = "\"${response.fact}\""
            } catch (e: Exception) {
                binding.tvCatFact.text = "Gagal mengambil data dari server."
            }
        }
    }

    private fun loadPhotos() {
        lifecycleScope.launch {
            try {
                val photos = PhotoApiClient.apiService.getPhotos()
                val adapter = PhotoAdapter(photos)
                binding.rvGallery.apply {
                    this.adapter = adapter
                    layoutManager = LinearLayoutManager(requireContext())
                }
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Gagal memuat galeri desa.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}