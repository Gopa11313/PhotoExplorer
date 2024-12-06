package com.gopal.photoexplorer.data.api

import com.gopal.photoexplorer.data.model.StoreResponse

interface StoreApiHelper {

    suspend fun getStoreDetails(
    ): StoreResponse
}