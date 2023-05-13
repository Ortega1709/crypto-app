package com.ortega.crypto_app.domain.useCase

import com.ortega.crypto_app.common.Resource
import com.ortega.crypto_app.data.remote.dto.toCryptoModel
import com.ortega.crypto_app.domain.model.CryptoModel
import com.ortega.crypto_app.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class getCryptosUseCase @Inject constructor(
    private val repository: CryptoRepository
) {

    operator fun invoke(): Flow<Resource<List<CryptoModel>>> = flow {
        try {

            emit(Resource.Loading())
            val cryptos = repository.getCryptos().map { it.toCryptoModel() }
            emit(Resource.Success(cryptos))

        } catch (e: HttpException) {

            emit(Resource.Error(e.localizedMessage ?: "An exception was occured"))

        } catch (e: IOException) {

            emit(Resource.Error("Couldn't reach server"))

        }
    }

}