package com.cleanapp.presentation.cryptos

import com.cleanapp.domain.model.Crypto
import java.lang.Error

data class CryptoState(
    val isLoading: Boolean = false,
    val crypto: List<Crypto> = emptyList(),
    val error: String = ""
)
