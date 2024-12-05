package com.gopal.photoexplorer.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gopal.photoexplorer.data.model.Photo
import com.gopal.photoexplorer.repository.PhotoRepository
import com.gopal.photoexplorer.utlis.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(private val repository: PhotoRepository) : ViewModel() {
    private val _photos = MutableLiveData<Resource<List<Photo>>>()
    val photos: LiveData<Resource<List<Photo>>> = _photos

    fun fetchPhotos(page: Int) {
        viewModelScope.launch {
            _photos.postValue(Resource.Loading()) // Post loading state
            try {
                // Fetch the PhotoResponse
                val response = repository.getRecentPhotos(page)
                // Extract the list of photos from the response and post as success
                _photos.postValue(Resource.Success(response.photos.photo))
            } catch (e: Exception) {
                // Post error state with the exception message
                _photos.postValue(Resource.Error(e.message ?: "An unexpected error occurred"))
            }
        }
    }

}