package com.cleanapp.presentation.cryptos

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleanapp.domain.usecase.CryptoUseCase
import com.cleanapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(
    private val cryptoUseCase: CryptoUseCase
) : ViewModel() {

    private val _cryptoState = mutableStateOf(CryptoState())
    val cryptoState: State<CryptoState> = _cryptoState

    init {
        getCrypto()
    }

    private var job: Job? = null

    private fun getCrypto() {
        job?.cancel()
        job = cryptoUseCase.getCrypto().onEach { resource ->
            when (resource) {
                is Resource.Loading -> {
                    _cryptoState.value = _cryptoState.value.copy(
                        isLoading = true
                    )
                }

                is Resource.Success -> {
                    _cryptoState.value = _cryptoState.value.copy(
                        isLoading = false,
                        crypto = resource.data ?: emptyList()
                    )
                }

                is Resource.Error -> {
                    _cryptoState.value = _cryptoState.value.copy(
                        error = resource.message ?: "error",
                        isLoading = false
                    )
                }
            }

        }.launchIn(viewModelScope)
    }

}