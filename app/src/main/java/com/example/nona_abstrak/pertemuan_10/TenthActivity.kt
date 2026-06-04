package com.example.nona_abstrak.pertemuan_10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.nona_abstrak.R
import com.example.nona_abstrak.databinding.ActivityTenthBinding
import com.google.android.material.tabs.TabLayoutMediator

class TenthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTenthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTenthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Setup Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "Bina Desa - Modul 10"
        }
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // 2. Inisialisasi Adapter
        val tabsAdapter = TenthTabsAdapter(this)

        // 3. Set adapter ke ViewPager2
        binding.viewPager.adapter = tabsAdapter

        // 4. Hubungkan TabLayout & ViewPager2 menggunakan TabLayoutMediator
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Info Desa"
                    tab.icon = ContextCompat.getDrawable(this, android.R.drawable.ic_menu_info_details)
                }
                1 -> {
                    tab.text = "Statistik"
                    tab.icon = ContextCompat.getDrawable(this, android.R.drawable.ic_menu_sort_by_size)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                    badge.number = 3
                }
                2 -> {
                    tab.text = "Produk"
                    tab.icon = ContextCompat.getDrawable(this, android.R.drawable.ic_menu_gallery)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                }
            }
        }.attach()
    }
}