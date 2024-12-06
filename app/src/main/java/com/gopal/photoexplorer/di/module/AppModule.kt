package com.gopal.photoexplorer.di.module

import com.gopal.photoexplorer.data.api.StoreApiHelper
import com.gopal.photoexplorer.data.api.StoreApiImpl
import com.gopal.photoexplorer.data.api.StoreApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://apituner.ecbsn.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideStoreApiService(retrofit: Retrofit): StoreApiService = retrofit.create(StoreApiService::class.java)

    @Provides
    @Singleton
    fun provideStoreServiceApiHelper(apiHelperImpl: StoreApiImpl): StoreApiHelper = apiHelperImpl
}