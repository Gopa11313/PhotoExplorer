package com.gopal.photoexplorer.data.model

data class PhotoResponse(
    val photos: PhotosMeta,
    val stat: String
)

data class PhotosMeta(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val total: String,
    val photo: List<Photo>
)