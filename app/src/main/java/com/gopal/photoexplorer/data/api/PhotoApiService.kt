package com.gopal.photoexplorer.data.api

import com.gopal.photoexplorer.data.model.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoApiService {
    @GET("photos.json")
    suspend fun getRecentPhotos(
        @Query("method") method: String = "flickr.photos.getRecent",
        @Query("api_key") apiKey: String = "fee10de350d1f31d5fec0eaf330d2dba",
        @Query("format") format: String = "json",
        @Query("nojsoncallback") noJsonCallback: Boolean = true,
        @Query("safe_search") safeSearch: Boolean = true,
        @Query("page") page: Int = 1
    ): PhotoResponse
}