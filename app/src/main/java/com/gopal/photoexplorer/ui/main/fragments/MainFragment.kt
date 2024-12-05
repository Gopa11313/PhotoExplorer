package com.gopal.photoexplorer.ui.main.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.gopal.photoexplorer.R
import com.gopal.photoexplorer.databinding.FragmentMainBinding
import com.gopal.photoexplorer.ui.main.fragments.Adapter.PhotoAdapter
import com.gopal.photoexplorer.ui.viewmodel.PhotoViewModel
import com.gopal.photoexplorer.utlis.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: PhotoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchPhotos(page = 1)
        setupObservers()
        setupQuickReturnPattern()
    }

    private fun setupObservers() {
        viewModel.photos.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.Loading -> {
                }

                is Resource.Success -> {
//                    binding.progressBar.visibility = View.GONE
                    Log.d("Gopal", resource.data.toString())
                    val adapter = PhotoAdapter(requireContext(), resource.data ?: emptyList()) { store ->
                        val action =
                            MainFragmentDirections.actionMainFragmentToDetailsFragment(store)
                        findNavController().navigate(action)
                    }
                    binding.listView.adapter = adapter
                }

                is Resource.Error -> {
                    Log.d("Gopal error:",resource.message!! )
                    Toast.makeText(context, resource.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setupQuickReturnPattern() {
        binding.listView.setOnScrollListener(object : AbsListView.OnScrollListener {
            var headerOffset = 0
            var previousTop = 0

            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {}

            override fun onScroll(
                view: AbsListView?,
                firstVisibleItem: Int,
                visibleItemCount: Int,
                totalItemCount: Int
            ) {
                val topView = binding.listView.getChildAt(0) ?: return
                val currentTop = topView.top
                val scrollDelta = previousTop - currentTop

                headerOffset += scrollDelta
                headerOffset = headerOffset.coerceIn(-binding.redHeader.height, 0)

                binding.redHeader.translationY = headerOffset.toFloat()
                previousTop = currentTop
            }
        })
    }
}