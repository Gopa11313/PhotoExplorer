package com.gopal.photoexplorer.data.api

import com.gopal.photoexplorer.data.model.PhotoResponse
import retrofit2.http.Query

interface PhotoApiHelper {

    suspend fun getRecentPhotos(
        page: Int
    ): PhotoResponse
}