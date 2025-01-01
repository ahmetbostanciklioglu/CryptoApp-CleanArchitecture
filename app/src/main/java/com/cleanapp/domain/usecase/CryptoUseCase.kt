package com.cleanapp.domain.usecase

import com.cleanapp.data.mapper.toCrypto
import com.cleanapp.domain.model.Crypto
import com.cleanapp.domain.repository.CryptoRepository
import com.cleanapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class CryptoUseCase @Inject constructor(
    private val cryptoRepository: CryptoRepository
) {

    fun getCrypto(): Flow<Resource<List<Crypto>>> = flow {
        try {
            emit(Resource.Loading())
            val crypto = cryptoRepository.getCrypto()
            if (crypto.success) {
                emit(Resource.Success(crypto.toCrypto()))
            } else {
                emit(Resource.Error("No crypto found!"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error("${e.localizedMessage}"))
        } catch (e: IOException) {
            emit(Resource.Error("${e.localizedMessage}"))
        }
    }
}