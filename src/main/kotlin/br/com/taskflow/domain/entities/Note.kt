package br.com.taskflow.domain.entities

import jakarta.persistence.*

@Entity
@Table(name = "note_table")
data class Note(
    val title: String = "",
    val description: String = "",
    val priority: Int = 0
) : BaseModel()