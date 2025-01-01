package com.cleanapp.data.remote

import com.cleanapp.data.remote.dto.CryptoDto
import com.cleanapp.util.Constants.API_KEY
import com.cleanapp.util.Constants.CONTENT_TYPE
import retrofit2.http.GET
import retrofit2.http.Header

interface CryptoAPI {

    @GET("economy/cripto")
    suspend fun getCrypto(
        @Header("content-type") type: String = CONTENT_TYPE,
        @Header("authorization") auth: String = API_KEY
    ): CryptoDto
}