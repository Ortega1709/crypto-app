package com.ortega.crypto_app.data.remote

import com.ortega.crypto_app.common.Constants.GET_CRYPTOS
import com.ortega.crypto_app.common.Constants.GET_CRYPTO_BY_ID
import com.ortega.crypto_app.data.remote.dto.CryptoDetailDto
import com.ortega.crypto_app.data.remote.dto.CryptoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoApi {

    @GET(GET_CRYPTOS)
    suspend fun getCryptos(): List<CryptoDto>

    @GET(GET_CRYPTO_BY_ID)
    suspend fun getCryptoById(@Path("cryptoId") cryptoId: String): CryptoDetailDto


}