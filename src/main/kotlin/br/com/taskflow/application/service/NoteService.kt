package br.com.taskflow.application.service

import br.com.taskflow.domain.entities.Note
import br.com.taskflow.domain.repositories.NoteRepository
import org.springframework.stereotype.Service

@Service
class NoteService(private val noteRepository: NoteRepository) {

    fun getAllNotes(): List<Note> = noteRepository.findAll()

    fun getNoteById(id: Long): Note = noteRepository.findById(id).orElseThrow {
        RuntimeException("Note not found with id $id")
    }

    fun saveNote(note: Note): Note = noteRepository.save(note)

    fun updateNote(id: Int, updatedNote: Note): Note {
        val existingNote = getNoteById(id.toLong())
        val noteToUpdate = existingNote.copy(
            title = updatedNote.title,
            description = updatedNote.description,
            priority = updatedNote.priority
        )
        return noteRepository.save(noteToUpdate)
    }

    fun deleteNote(id: Int) {
        val note = getNoteById(id.toLong())
        noteRepository.delete(note)
    }
}
