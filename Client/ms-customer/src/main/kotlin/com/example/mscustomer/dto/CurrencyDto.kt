package com.example.mscustomer.dto

import java.math.BigDecimal

data class CurrencyDto(
        var success: Boolean,
        var query: RequestDto?,
        var info: InfoDto?,
        var date: String?,
        var result: BigDecimal?
){
    constructor() : this(false,null,null,null,null)

    override fun toString(): String {
        return "CurrencyDto(success=$success, query=$query, info=$info, date='$date', result=$result)"
    }
}