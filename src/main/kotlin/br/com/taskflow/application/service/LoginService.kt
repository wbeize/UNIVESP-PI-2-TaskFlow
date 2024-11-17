package br.com.taskflow.application.service

import br.com.taskflow.domain.entities.LoginRequest
import br.com.taskflow.domain.entities.LoginResponse
import br.com.taskflow.infrastructure.config.ApiProperties
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class LoginService(
    private val restTemplate: RestTemplate,
    private val apiProperties: ApiProperties
) {

    fun login(loginRequest: LoginRequest): LoginResponse {
        val response = restTemplate.postForEntity(
            "${apiProperties.loginUrl}signing",
            loginRequest,
            LoginResponse::class.java
        )
        return response.body ?: LoginResponse()
    }
}