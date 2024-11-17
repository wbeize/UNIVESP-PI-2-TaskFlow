package br.com.taskflow.domain.entities

enum class IssuePriority(val priority: Int) {
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    EMERGENT(4)
}
