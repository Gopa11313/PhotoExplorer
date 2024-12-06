package com.gopal.photoexplorer.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gopal.photoexplorer.data.model.Store
import com.gopal.photoexplorer.repository.StoreRepository
import com.gopal.photoexplorer.utlis.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(private val repository: StoreRepository) : ViewModel() {
    private val _photos = MutableLiveData<Resource<List<Store>>>()
    val photos: LiveData<Resource<List<Store>>> = _photos
    var store: Store? = null
    var title= MutableLiveData<String>()
    fun fetchPhotos() {
        viewModelScope.launch {
            _photos.postValue(Resource.Loading())
            try {
                val response = repository.getStoreDetails()
                _photos.postValue(Resource.Success(response.store))
            } catch (e: Exception) {
                // Post error state with the exception message
                _photos.postValue(Resource.Error(e.message ?: "An unexpected error occurred"))
            }
        }
    }

}