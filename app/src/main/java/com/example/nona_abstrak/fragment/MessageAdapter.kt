package com.example.nona_abstrak.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.nona_abstrak.databinding.ItemMessageBinding
import com.google.android.material.snackbar.Snackbar

class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root
        val message = messages[position]

        Glide.with(context)
            .load(message.avatarUrl)
            .circleCrop()
            .into(binding.avatarImg)

        binding.textSender.text = message.senderName
        binding.textMessage.text = message.messageText

        view.setOnClickListener {
            Snackbar.make(
                parent,
                "Pesan dari ${message.senderName}: ${message.messageText}",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        return view
    }
}