package com.cleanapp.presentation.cryptos

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cleanapp.presentation.cryptos.components.CryptoItem

@Composable
fun CryptoScreen(cryptoViewModel: CryptoViewModel = hiltViewModel()) {
    val state = cryptoViewModel.cryptoState.value

    when {
        state.error.isNotBlank() -> {
            Box(Modifier.fillMaxSize()) {
                Text(
                    state.error,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .align(Alignment.Center)
                )
            }
        }

        state.isLoading -> {
            Box(Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        else -> {
            CryptoFun(cryptoState = state)
        }
    }


}

@Composable
fun CryptoFun(
    cryptoState: CryptoState
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp)
        ) {
            items(cryptoState.crypto) { crypto ->
                CryptoItem(crypto = crypto)
                HorizontalDivider()
            }
        }
    }
}