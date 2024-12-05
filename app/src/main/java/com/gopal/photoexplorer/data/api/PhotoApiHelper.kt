package com.gopal.photoexplorer.data.api

import com.gopal.photoexplorer.data.model.StoreResponse
import retrofit2.http.Query

interface PhotoApiHelper {

    suspend fun getStoreDetails(
    ): StoreResponse
}