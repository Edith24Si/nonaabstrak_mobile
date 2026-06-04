package com.example.nona_abstrak.fragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.nona_abstrak.R
import com.example.nona_abstrak.databinding.FragmentMessageBinding
import com.example.nona_abstrak.fragment.tutorial.TutorialMessageActivity
import com.example.nona_abstrak.pertemuan_9.MessageAdapter
import com.example.nona_abstrak.pertemuan_9.MessageModel

class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel("Admin Desa", "Selamat datang di fitur pesan Bina Desa.", "https://avatar.iran.liara.run/public/12"),
        MessageModel("Alya",  "Halo! Apa kabar?",          "https://avatar.iran.liara.run/public/1"),
        MessageModel("Budi",  "Sudah makan?",              "https://avatar.iran.liara.run/public/2"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!",  "https://avatar.iran.liara.run/public/3"),
        MessageModel("Dika",  "Besok kita rapat jam 9",    "https://avatar.iran.liara.run/public/4"),
        MessageModel("Eka",   "Nice job kemarin!",         "https://avatar.iran.liara.run/public/5"),
        MessageModel("Fajar", "Lagi ngapain?",             "https://avatar.iran.liara.run/public/6"),
        MessageModel("Gita",  "Boleh minta tolong?",       "https://avatar.iran.liara.run/public/7"),
        MessageModel("Hana",  "Lihat email ya",            "https://avatar.iran.liara.run/public/8"),
        MessageModel("Irfan", "Oke noted",                 "https://avatar.iran.liara.run/public/9"),
        MessageModel("Joko",  "Sampai jumpa besok",        "https://avatar.iran.liara.run/public/10"),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Message"
        }
        setHasOptionsMenu(true)

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItem.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tutorial -> {
                val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}