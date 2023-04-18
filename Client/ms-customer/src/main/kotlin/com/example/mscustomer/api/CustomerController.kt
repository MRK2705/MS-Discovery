package com.example.mscustomer.api

import com.example.mscustomer.consumer.NotificationConsumer
import com.example.mscustomer.dto.CurrencyDto
import com.example.mscustomer.dto.NotificationDto
import com.example.mscustomer.dto.RequestDto
import com.example.mscustomer.dto.TokenDto
import com.example.mscustomer.service.AccountService
import com.example.mscustomer.service.CurrencyService
import com.example.mscustomer.service.KeycloakService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Date

@RestController
@RequestMapping("/customer")
class CustomerController @Autowired constructor(private val accountService: AccountService,
                                                private val keycloakService: KeycloakService,
                                                private val currencyService: CurrencyService) {

    @Value("7070")
    lateinit var port: String

    @Value("client_credentials")
    lateinit var grantType: String

    @Value("backend")
    lateinit var clientId: String

    @Value("xmfeZdBq5R9jtxbZTomrKhbwdSxAo833")
    lateinit var clientSecret: String

    @GetMapping("/test")
    fun test(): String {
        val result = accountService.test()
        return "server port: $port -> $result"
    }

    @GetMapping("/list")
    fun getCustomers(): List<String> {
        return listOf("Customer 1", "Customer 2", "Customer 3") + accountService.list()
    }

    @GetMapping("/token")
    fun getToken(): TokenDto {
        return keycloakService.getToken(mapOf("grant_type" to grantType,
                "client_id" to clientId,
                "client_secret" to clientSecret
        ))
    }

    @GetMapping("/obtain")
    fun convert(): RequestDto {
        return currencyService.obtain("USD", "EUR", 100.toBigDecimal())
    }

}