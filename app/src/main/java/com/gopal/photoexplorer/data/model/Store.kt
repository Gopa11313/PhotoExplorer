package com.gopal.photoexplorer.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Store(
    val id: Int,
    val name: String,
    val shortDescription: String,
    val description: String,
    val images: Images
) : Parcelable {
    // Helper method to construct the full image URL for a thumbnail
    fun getThumbnailUrl(): String {
        return "https://static.rakuten.com${images.thumbnail}"
    }

    // Helper method to construct the full image URL for a banner
    fun getBannerUrl(): String {
        return "https://static.rakuten.com${images.banner?:images.smallLogo}"
    }
}