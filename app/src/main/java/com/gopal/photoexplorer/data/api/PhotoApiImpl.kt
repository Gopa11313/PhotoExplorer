package com.gopal.photoexplorer.data.api


import com.gopal.photoexplorer.data.model.StoreResponse
import javax.inject.Inject

class PhotoApiImpl @Inject constructor(val photoApiService: PhotoApiService) : PhotoApiHelper {
    override suspend fun getStoreDetails(): StoreResponse =
        photoApiService.getStoreDetails(
        )
}