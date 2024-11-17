package br.com.taskflow.domain.repositories

import br.com.taskflow.domain.entities.Issue
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IssueRepository : JpaRepository<Issue, Int>