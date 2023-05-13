package com.ortega.crypto_app.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.ortega.crypto_app.domain.model.CryptoModel

data class CryptoDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CryptoDto.toCryptoModel(): CryptoModel {

    return CryptoModel(
        id = id,
        is_active = is_active,
        is_new =  is_new,
        name =  name,
        rank = rank,
        symbol =  symbol,
        type = type)
}