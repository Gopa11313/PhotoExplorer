package com.gopal.photoexplorer.data.api


import com.gopal.photoexplorer.data.model.StoreResponse
import javax.inject.Inject

class StoreApiImpl @Inject constructor(val storeApiService: StoreApiService) : StoreApiHelper {
    override suspend fun getStoreDetails(): StoreResponse =
        storeApiService.getStoreDetails(
        )
}