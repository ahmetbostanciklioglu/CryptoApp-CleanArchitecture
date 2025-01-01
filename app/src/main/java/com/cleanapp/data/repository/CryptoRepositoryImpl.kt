package com.cleanapp.data.repository

import com.cleanapp.data.remote.CryptoAPI
import com.cleanapp.data.remote.dto.CryptoDto
import com.cleanapp.domain.repository.CryptoRepository
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
   private  val cryptoAPI: CryptoAPI
) : CryptoRepository {

    override suspend fun getCrypto(): CryptoDto {
        return cryptoAPI.getCrypto()
    }
}