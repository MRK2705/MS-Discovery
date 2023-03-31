package com.example.mscustomer.service

import com.example.mscustomer.dto.RequestDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import java.math.BigDecimal

@FeignClient(name = "currency-converter", url = "http://localhost:8080/api/v1/currency")
interface CurrencyService {

    @GetMapping("/obtain", consumes = ["application/json"])
    fun obtain(@RequestParam from: String, @RequestParam to: String, @RequestParam amount: BigDecimal): RequestDto


    @GetMapping("/list")
        fun list(@RequestParam page: Int, @RequestParam size: Int): List<String>

}