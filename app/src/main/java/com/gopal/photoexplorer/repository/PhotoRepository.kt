package com.gopal.photoexplorer.repository

import com.gopal.photoexplorer.data.api.PhotoApiHelper
import javax.inject.Inject

class PhotoRepository @Inject constructor(private val photoApiHelper: PhotoApiHelper) {

    suspend fun getRecentPhotos(page: Int) = photoApiHelper.getRecentPhotos(page)

}