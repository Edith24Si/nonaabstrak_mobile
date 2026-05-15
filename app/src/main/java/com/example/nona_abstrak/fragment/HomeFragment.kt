package com.example.nona_abstrak.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.nona_abstrak.pertemuan5.WebViewActivity
import com.example.nona_abstrak.databinding.FragmentHomeBinding
import com.example.nona_abstrak.pertemuan6.AuthActivity
import com.example.nona_abstrak.pertemuan_9.SettingActivity
import com.google.android.material.chip.Chip

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

        // Toolbar
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home Bina Desa"
        }

        // ChipGroup
        binding.chipGroupKategori.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull()
            if (selectedChipId != null) {
                val chip = group.findViewById<Chip>(selectedChipId)
                Toast.makeText(requireContext(), "Filter: ${chip.text}", Toast.LENGTH_SHORT).show()
            }
        }

        // GridLayout buttons
        binding.btnBumdes.setOnClickListener {
            Toast.makeText(requireContext(), "Bumdes", Toast.LENGTH_SHORT).show()
        }

        binding.btnProfil.setOnClickListener {
            Toast.makeText(requireContext(), "Profil", Toast.LENGTH_SHORT).show()
        }

        binding.btnForum.setOnClickListener {
            Toast.makeText(requireContext(), "Forum", Toast.LENGTH_SHORT).show()
        }

        binding.btnWebView.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java))
        }

        // Tentang Aplikasi
        binding.btnTentangAplikasi.setOnClickListener {
            startActivity(Intent(requireContext(), SettingActivity::class.java))
        }

        // Logout
        binding.btnLogout.setOnClickListener {
            val sharedPref = requireContext().getSharedPreferences("RegulasiDesaPref", AppCompatActivity.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.clear()
            editor.apply()
            startActivity(Intent(requireContext(), AuthActivity::class.java))
            requireActivity().finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}