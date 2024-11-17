package br.com.taskflow.infrastructure.config

import br.com.taskflow.domain.entities.Note
import br.com.taskflow.domain.repositories.NoteRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DatabaseSeeder(private val noteRepository: NoteRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        if (noteRepository.count() == 0L) {
            val notes = listOf(
                Note(title = "Title 1", description = "Description 1", priority = 1),
                Note(title = "Title 2", description = "Description 2", priority = 2),
                Note(title = "Title 3", description = "Description 3", priority = 3)
            )
            noteRepository.saveAll(notes)
        }
    }
}
