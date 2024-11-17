package br.com.taskflow.application.service

import br.com.taskflow.domain.entities.Issue
import br.com.taskflow.domain.entities.IssuePriority
import br.com.taskflow.infrastructure.config.ApiProperties
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class IssueService(
    private val restTemplate: RestTemplate,
    private val apiProperties: ApiProperties
) {

    fun getAllIssues(token: String): List<Issue> {
        val headers = org.springframework.http.HttpHeaders()
        headers.set("Authorization", "Bearer $token")
        val entity = org.springframework.http.HttpEntity<Any>(headers)

        val response = restTemplate.exchange(
            "${apiProperties.issueUrl}issues",
            org.springframework.http.HttpMethod.GET,
            entity,
            Array<Issue>::class.java
        )
        return response.body?.toList() ?: emptyList()
    }
}