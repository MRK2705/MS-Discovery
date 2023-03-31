package com.example.mscustomer.service

import com.example.mscustomer.dto.TokenDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import javax.ws.rs.core.MediaType

@FeignClient(name = "keycloak", url = "http://localhost:8081/realms/software/protocol/openid-connect")
interface KeycloakService {

    @PostMapping("/token", consumes = [MediaType.APPLICATION_FORM_URLENCODED])
    fun getToken(formParams:Map<String, *>): TokenDto

}