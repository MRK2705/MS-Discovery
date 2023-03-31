package com.example.mscustomer.dto

data class TokenDto(
    val access_token: String,
    val expires_in: Int,
    val refresh_expires_in: Int,
    val token_type: String,
    val not_before_policy: Int,
    val scope: String,
)