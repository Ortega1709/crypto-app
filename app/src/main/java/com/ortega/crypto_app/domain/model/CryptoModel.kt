package com.ortega.crypto_app.domain.model

import com.google.gson.annotations.SerializedName

data class CryptoModel (
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

