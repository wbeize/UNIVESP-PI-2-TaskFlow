package br.com.taskflow.infrastructure.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "api")
data class ApiProperties(
    var loginUrl: String = "",
    var issueUrl: String = ""
)