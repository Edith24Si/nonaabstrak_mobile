package com.example.nona_abstrak.fragment.tutorial

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nona_abstrak.databinding.FragmentTutorial3Binding
import com.example.nona_abstrak.pertemuan6.AuthActivity

class Tutorial3Fragment : Fragment() {
    private var _binding: FragmentTutorial3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTutorial3Binding.inflate(inflater, container, false)
        
        binding.btnGetStarted.setOnClickListener {
            val intent = Intent(requireContext(), AuthActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
        
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
