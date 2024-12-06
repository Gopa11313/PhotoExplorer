package com.gopal.photoexplorer.data.api

import com.gopal.photoexplorer.data.model.StoreResponse
import com.gopal.photoexplorer.utlis.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface StoreApiService {
    @GET("apituner/mobile/store/detail/list")
    suspend fun getStoreDetails(
        @Query("id") ids: String = Constants.DEFAULT_IDS
    ): StoreResponse
}