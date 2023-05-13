package com.ortega.crypto_app.domain.repository

import com.ortega.crypto_app.data.remote.dto.CryptoDetailDto
import com.ortega.crypto_app.data.remote.dto.CryptoDto

interface CryptoRepository {

    suspend fun getCryptos(): List<CryptoDto>

    suspend fun getCryptoById(cryptoId: String): CryptoDetailDto

}