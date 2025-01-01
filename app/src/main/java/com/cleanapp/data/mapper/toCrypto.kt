package com.cleanapp.data.mapper

import com.cleanapp.data.remote.dto.CryptoDto
import com.cleanapp.domain.model.Crypto

fun CryptoDto.toCrypto(): List<Crypto> {
    return result.map { mapToModel ->
        Crypto(
            code = mapToModel.code,
            currency = mapToModel.currency,
            pricestr = mapToModel.pricestr
        )
    }
}