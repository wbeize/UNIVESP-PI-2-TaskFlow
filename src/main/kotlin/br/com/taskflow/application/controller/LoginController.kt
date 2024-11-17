package br.com.taskflow.application.controller

import br.com.taskflow.application.service.LoginService
import br.com.taskflow.domain.entities.LoginRequest
import br.com.taskflow.domain.entities.LoginResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class LoginController(private val loginService: LoginService) {

    @PostMapping("/signin")
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<LoginResponse> {
        val response = loginService.login(loginRequest)
        return if (response.jwt.isNotEmpty()) {
            ResponseEntity.ok(response)
        } else {
            ResponseEntity.badRequest().build()
        }
    }
}