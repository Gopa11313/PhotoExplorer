package com.gopal.photoexplorer.ui.main.fragments.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.gopal.photoexplorer.R
import com.gopal.photoexplorer.data.model.Photo
import com.gopal.photoexplorer.databinding.ItemPhotoBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.NonDisposableHandle.parent

class PhotoAdapter(val context: Context, val data: List<Photo>) : BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(p0: Int): Photo {
        return data[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ItemPhotoBinding

        if (convertView == null) {
            // Inflate the layout and create binding
            binding = ItemPhotoBinding.inflate(LayoutInflater.from(context), parent, false)
            binding.root.tag = binding
        } else {
            // Reuse the existing binding
            binding = convertView.tag as ItemPhotoBinding
        }

        val photo = getItem(position)
        binding.photoTitle.text = photo.title
        Picasso.get().load(photo.getPhotoUrl()).error(R.drawable.ic_launcher_background)
            .into(binding.imageView)
        binding.photoDescription.text = photo.owner
        return binding.root
    }
}