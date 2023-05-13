package com.ortega.crypto_app.domain.useCase

import com.ortega.crypto_app.common.Resource
import com.ortega.crypto_app.data.remote.dto.toCryptoDetailDtoModel
import com.ortega.crypto_app.data.remote.dto.toCryptoModel
import com.ortega.crypto_app.domain.model.CryptoDetailModel
import com.ortega.crypto_app.domain.model.CryptoModel
import com.ortega.crypto_app.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class getCryptoUseCase @Inject constructor(
    private val repository: CryptoRepository
) {

    operator fun invoke(cryptoId: String): Flow<Resource<CryptoDetailModel>> = flow {
        try {

            emit(Resource.Loading())
            val crypto = repository.getCryptoById(cryptoId = cryptoId).toCryptoDetailDtoModel()
            emit(Resource.Success(crypto))

        } catch (e: HttpException) {

            emit(Resource.Error(e.localizedMessage ?: "An exception was occured"))

        } catch (e: IOException) {

            emit(Resource.Error("Couldn't reach server"))

        }
    }

}