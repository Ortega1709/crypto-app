package com.ortega.crypto_app.di

import com.ortega.crypto_app.common.Constants.BASE_URL
import com.ortega.crypto_app.data.remote.CryptoApi
import com.ortega.crypto_app.data.repository.CryptoRepositoryImpl
import com.ortega.crypto_app.domain.repository.CryptoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideCryptoApi(): CryptoApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCryptoRepository(api: CryptoApi): CryptoRepository {
        return CryptoRepositoryImpl(api)
    }

}