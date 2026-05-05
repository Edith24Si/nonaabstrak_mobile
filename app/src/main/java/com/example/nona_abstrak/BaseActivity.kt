package com.example.nona_abstrak

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.nona_abstrak.databinding.ActivityBaseBinding
import com.example.nona_abstrak.fragment.AboutFragment
import com.example.nona_abstrak.fragment.HomeFragment
import com.example.nona_abstrak.fragment.ProfileFragment
class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Hilangkan padding systemBars bawah agar BottomNav tidak ada jarak
        binding.root.setPadding(0, 0, 0, 0)
        // Tampilkan HomeFragment sebagai default
        replaceFragment(HomeFragment())
        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> { replaceFragment(HomeFragment()); true }
                R.id.nav_about -> { replaceFragment(AboutFragment()); true }
                R.id.nav_profile -> { replaceFragment(ProfileFragment()); true }
                else -> false
            }
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
    }
}