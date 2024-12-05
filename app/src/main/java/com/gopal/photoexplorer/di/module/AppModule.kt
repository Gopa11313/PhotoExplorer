package com.gopal.photoexplorer.di.module

import com.gopal.photoexplorer.data.api.PhotoApiHelper
import com.gopal.photoexplorer.data.api.PhotoApiImpl
import com.gopal.photoexplorer.data.api.PhotoApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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
    fun providePhotoApiService(retrofit: Retrofit): PhotoApiService = retrofit.create(PhotoApiService::class.java)

    @Provides
    @Singleton
    fun providePhotoServiceApiHelper(apiHelperImpl: PhotoApiImpl): PhotoApiHelper = apiHelperImpl
}