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

    private val legalProductList = listOf(
        ProductModel("Perdes No. 1 2024 tentang APBDes", "Status: Berlaku", "https://picsum.photos/seed/legal1/400/300"),
        ProductModel("Perkades No. 2 2024 - Tata Tertib", "Status: Berlaku", "https://picsum.photos/seed/legal2/400/300"),
        ProductModel("SK Kades No. 15 - Posyandu", "Status: Berlaku", "https://picsum.photos/seed/legal3/400/300"),
        ProductModel("Perdes No. 3 2023 tentang BUMDes", "Status: Berlaku", "https://picsum.photos/seed/legal4/400/300"),
        ProductModel("Perkades No. 5 2023 - Kebersihan", "Status: Berlaku", "https://picsum.photos/seed/legal5/400/300"),
        ProductModel("SK Kades No. 20 - Karang Taruna", "Status: Berlaku", "https://picsum.photos/seed/legal6/400/300"),
        ProductModel("Perdes No. 4 2023 tentang Irigasi", "Status: Berlaku", "https://picsum.photos/seed/legal7/400/300"),
        ProductModel("Perdes No. 2 2023 - Batas Wilayah", "Status: Berlaku", "https://picsum.photos/seed/legal8/400/300"),
        ProductModel("SK Kades No. 10 - Satgas COVID", "Status: Tidak Berlaku", "https://picsum.photos/seed/legal9/400/300"),
        ProductModel("Perkades No. 1 2024 - Jam Malam", "Status: Berlaku", "https://picsum.photos/seed/legal10/400/300")
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

        val adapter = ProductAdapter(legalProductList) { selectedItem ->
            Toast.makeText(requireContext(), "Membuka: ${selectedItem.name}", Toast.LENGTH_SHORT).show()
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