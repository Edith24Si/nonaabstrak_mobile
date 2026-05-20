package com.example.nona_abstrak.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.nona_abstrak.databinding.FragmentHomeBinding
import com.example.nona_abstrak.pertemuan5.WebViewActivity
import com.example.nona_abstrak.pertemuan6.AuthActivity
import com.example.nona_abstrak.pertemuan9.NinthActivity
import com.example.nona_abstrak.pertemuan10.TenthActivity
import com.example.nona_abstrak.pertemuan_9.SettingActivity
import com.example.nona_abstrak.Home.pertemuan2.SecondActivity
import com.example.nona_abstrak.tugaspertemuan3.LoginActivityTugas3
import com.example.nona_abstrak.tugasPertemuan4.HalamanUtama

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val sliderHandler = Handler(Looper.getMainLooper())
    private val sliderRunnable = Runnable {
        val currentItem = binding.viewPagerSlider.currentItem
        val nextItem = if (currentItem == 2) 0 else currentItem + 1
        binding.viewPagerSlider.currentItem = nextItem
    }

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
            title = "Bina Desa"
        }

        setupSlider()

        // Menu Produk Hukum (Eks Pertemuan 10)
        binding.btnProdukHukum.setOnClickListener {
            startActivity(Intent(requireContext(), TenthActivity::class.java))
        }

        // Menu Informasi Desa (Eks Pertemuan 9)
        binding.btnInformasiDesa.setOnClickListener {
            startActivity(Intent(requireContext(), NinthActivity::class.java))
        }

        // Menu Aspirasi (Eks Pertemuan 2)
        binding.btnAspirasi.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        // Menu Web Desa (Eks Pertemuan 5)
        binding.btnWebView.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java))
        }

        // Galeri Desa (Tugas Pertemuan 4)
        binding.btnGaleriDesa.setOnClickListener {
            startActivity(Intent(requireContext(), HalamanUtama::class.java))
        }

        // Layanan Mandiri (Tugas Pertemuan 3)
        binding.btnLayananMandiri.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivityTugas3::class.java)
            intent.putExtra("Judul_Halaman", "Layanan Mandiri")
            intent.putExtra("Description", "Silakan login untuk akses layanan mandiri warga.")
            startActivity(intent)
        }

        // Pengaturan & Akun
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

    private fun setupSlider() {
        val images = listOf(
            "https://picsum.photos/seed/desa1/800/400",
            "https://picsum.photos/seed/desa2/800/400",
            "https://picsum.photos/seed/desa3/800/400"
        )

        binding.viewPagerSlider.adapter = object : RecyclerView.Adapter<SliderViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
                val imageView = ImageView(parent.context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    scaleType = ImageView.ScaleType.CENTER_CROP
                }
                return SliderViewHolder(imageView)
            }

            override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
                Glide.with(holder.itemView.context)
                    .load(images[position])
                    .into(holder.itemView as ImageView)
            }

            override fun getItemCount(): Int = images.size
        }

        binding.viewPagerSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 3000) // Geser setiap 3 detik
            }
        })
    }

    class SliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onPause() {
        super.onPause()
        sliderHandler.removeCallbacks(sliderRunnable)
    }

    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRunnable, 3000)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}