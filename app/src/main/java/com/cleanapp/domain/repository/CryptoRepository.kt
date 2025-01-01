package com.cleanapp.domain.repository

import com.cleanapp.data.remote.dto.CryptoDto

interface CryptoRepository {
    suspend fun getCrypto(): CryptoDto
}