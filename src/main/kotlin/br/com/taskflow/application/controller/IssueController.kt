package br.com.taskflow.application.controller

import br.com.taskflow.application.service.IssueService
import br.com.taskflow.domain.entities.Issue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/issues")
class IssueController(private val issueService: IssueService) {

    @GetMapping
    fun getAllIssues(@RequestHeader("Authorization") token: String): List<Issue> {
        return issueService.getAllIssues(token)
    }
}