package com.gopal.photoexplorer.ui.main.fragments.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.gopal.photoexplorer.R
import com.gopal.photoexplorer.data.model.Store
import com.gopal.photoexplorer.databinding.ItemStoreBinding
import com.squareup.picasso.Picasso

class StoreAdapter(
    private val context: Context,
    val data: List<Store>,
    val onClick: (Store) -> Unit
) :
    BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }


    override fun getItem(p0: Int): Store {
        return data[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ItemStoreBinding

        if (convertView == null) {
            // Inflate the layout and create binding
            binding = ItemStoreBinding.inflate(LayoutInflater.from(context), parent, false)
            binding.root.tag = binding
        } else {
            // Reuse the existing binding
            binding = convertView.tag as ItemStoreBinding
        }
        val photo = getItem(position)
        binding.photoTitle.text = photo.name
        Picasso.get().load(photo.getBannerUrl()).error(R.drawable.ic_launcher_background)
            .into(binding.imageView)
        binding.photoDescription.text = photo.description
        binding.mainLayout.setOnClickListener {
            onClick(photo)
        }
        return binding.root
    }
}