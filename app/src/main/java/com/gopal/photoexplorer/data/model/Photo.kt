package com.gopal.photoexplorer.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Photo(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Int,
    val title: String,
    val ispublic: Int,
    val isfriend: Int,
    val isfamily: Int
) : Parcelable {
    // Helper method to construct the photo URL
    fun getPhotoUrl(): String {
        return "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"
    }
}