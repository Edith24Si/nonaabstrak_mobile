package com.example.nona_abstrak.pertemuan10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nona_abstrak.databinding.FragmentTabCBinding

class TabCFragment : Fragment() {
    private var _binding: FragmentTabCBinding? = null
    private val binding get() = _binding!!

    private val productList = listOf(
        ProductModel("Pupuk Organik Desa", "Rp 50.000", "https://picsum.photos/seed/pupuk/400/300"),
        ProductModel("Beras Merah Cianjur", "Rp 85.000", "https://picsum.photos/seed/beras/400/300"),
        ProductModel("Madu Hutan Asli", "Rp 120.000", "https://picsum.photos/seed/madu/400/300"),
        ProductModel("Kopi Robusta Desa", "Rp 45.000", "https://picsum.photos/seed/kopi/400/300"),
        ProductModel("Keripik Singkong", "Rp 15.000", "https://picsum.photos/seed/keripik/400/300"),
        ProductModel("Gula Semut Kelapa", "Rp 25.000", "https://picsum.photos/seed/gula/400/300"),
        ProductModel("Teh Hijau Alami", "Rp 35.000", "https://picsum.photos/seed/teh/400/300"),
        ProductModel("Minyak Kelapa Mandiri", "Rp 60.000", "https://picsum.photos/seed/minyak/400/300"),
        ProductModel("Sambal Tradisional", "Rp 20.000", "https://picsum.photos/seed/sambal/400/300"),
        ProductModel("Telur Ayam Kampung", "Rp 3.000", "https://picsum.photos/seed/telur/400/300"),
        ProductModel("Bibit Tanaman Buah", "Rp 25.000", "https://picsum.photos/seed/bibit/400/300"),
        ProductModel("Cangkul Baja Kuat", "Rp 75.000", "https://picsum.photos/seed/cangkul/400/300"),
        ProductModel("Caping Petani", "Rp 30.000", "https://picsum.photos/seed/caping/400/300"),
        ProductModel("Sepatu Boot Karet", "Rp 55.000", "https://picsum.photos/seed/boot/400/300"),
        ProductModel("Semprotan Hama", "Rp 150.000", "https://picsum.photos/seed/semprot/400/300")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ProductAdapter(productList) { selectedItem ->
            Toast.makeText(requireContext(), "Melihat detail ${selectedItem.name}", Toast.LENGTH_SHORT).show()
        }

        binding.rvProducts.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            this.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}