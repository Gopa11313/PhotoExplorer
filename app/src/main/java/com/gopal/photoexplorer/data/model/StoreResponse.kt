package com.gopal.photoexplorer.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class StoreResponse(
    val store: List<Store>
)
@Parcelize
data class Images(
    val banner: String?,
    val thumbnail: String?,
    val smallLogo: String?
) : Parcelable