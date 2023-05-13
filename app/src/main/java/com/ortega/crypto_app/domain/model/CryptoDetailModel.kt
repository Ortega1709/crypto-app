package com.ortega.crypto_app.domain.model

import com.ortega.crypto_app.data.remote.dto.Team

data class CryptoDetailModel (
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val is_active: Boolean,
    val tags: List<String>,
    val team: List<Team>
)

