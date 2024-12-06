package com.gopal.photoexplorer.data.api

import com.gopal.photoexplorer.data.model.StoreResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface StoreApiService {
    @GET("apituner/mobile/store/detail/list")
    suspend fun getStoreDetails(
        @Query("id") ids: String = "5246,14295,14296,14316,14319,14321,14322,14323,14324,14325"
    ): StoreResponse
}