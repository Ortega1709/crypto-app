package com.ortega.crypto_app.data.repository

import com.ortega.crypto_app.data.remote.CryptoApi
import com.ortega.crypto_app.data.remote.dto.CryptoDetailDto
import com.ortega.crypto_app.data.remote.dto.CryptoDto
import com.ortega.crypto_app.domain.repository.CryptoRepository
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val api: CryptoApi
) : CryptoRepository {

    override suspend fun getCryptos(): List<CryptoDto> {
        return api.getCryptos()
    }

    override suspend fun getCryptoById(cryptoId: String): CryptoDetailDto {
        return api.getCryptoById(cryptoId)
    }
}