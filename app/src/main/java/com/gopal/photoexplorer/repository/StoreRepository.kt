package com.gopal.photoexplorer.repository

import com.gopal.photoexplorer.data.api.StoreApiHelper
import javax.inject.Inject

class StoreRepository @Inject constructor(private val storeApiHelper: StoreApiHelper) {

    suspend fun getStoreDetails() = storeApiHelper.getStoreDetails()

}