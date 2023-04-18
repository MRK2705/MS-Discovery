package com.example.mscustomer.dto

import java.util.Date
data class NotificationDto (
    val message: String = "",
    val type: String = "",
    val date: Date = Date()
)