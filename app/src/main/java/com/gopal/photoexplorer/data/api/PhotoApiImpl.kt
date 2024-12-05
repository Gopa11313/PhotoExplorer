package com.gopal.photoexplorer.data.api

import com.gopal.photoexplorer.data.model.PhotoResponse
import javax.inject.Inject

class PhotoApiImpl @Inject constructor(val photoApiService: PhotoApiService) : PhotoApiHelper {
    override suspend fun getRecentPhotos(page: Int): PhotoResponse =
        photoApiService.getRecentPhotos(
            "flickr.photos.getRecent",
            "fee10de350d1f31d5fec0eaf330d2dba",
            "json",
            true,
            true,
            page = page
        )
}