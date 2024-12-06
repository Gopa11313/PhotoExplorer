package com.gopal.photoexplorer.ui.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.gopal.photoexplorer.R
import com.gopal.photoexplorer.data.model.Store
import com.gopal.photoexplorer.databinding.FragmentDetailsBinding
import com.gopal.photoexplorer.ui.viewmodel.StoreViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()
    private val viewModel: StoreViewModel by activityViewModels()
    private var store: Store? = null
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
        store = args.store
        Picasso.get().load(store!!.getBannerUrl()).error(R.drawable.ic_launcher_background)
            .into(binding.image)
        binding.title.text = store!!.name
        binding.shortDescription.text = store!!.shortDescription
        binding.description.text = store!!.description

    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.title.value = store?.name
    }

}