package com.gopal.photoexplorer.ui.main.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.gopal.photoexplorer.R
import com.gopal.photoexplorer.databinding.FragmentDetailsBinding
import com.gopal.photoexplorer.ui.viewmodel.PhotoViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()
    private val viewModel: PhotoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (viewModel.store == null) {
            viewModel.store = args.store
        }
        val store = viewModel.store!!
        Picasso.get().load(store.getBannerUrl()).error(R.drawable.ic_launcher_background).into(binding.image)
        binding.title.text = store.name
        binding.description.text = store.description
//        binding.image
        Log.d("Gopal","Here")
        print(store)
    }

}