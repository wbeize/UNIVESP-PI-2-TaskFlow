package br.com.taskflow.domain.entities

class LoginResponse (
    val username: String = "",
    val grants: List<String> = emptyList(),
    val jwt: String = ""
)