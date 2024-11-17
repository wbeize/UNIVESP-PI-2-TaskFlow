package br.com.taskflow.application.controller

import br.com.taskflow.application.service.NoteService
import br.com.taskflow.domain.entities.Note
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/notes")
class NoteController(private val noteService: NoteService) {

    @GetMapping
    fun getAllNotes(): ResponseEntity<List<Note>> {
        val notes = noteService.getAllNotes()
        return if (notes.isEmpty()) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.ok(notes)
        }
    }

    @GetMapping("/{id}")
    fun getNoteById(@PathVariable id: Int): ResponseEntity<Note> {
        return ResponseEntity.ok(noteService.getNoteById(id.toLong()))
    }

    @PostMapping
    fun saveNote(@RequestBody note: Note): ResponseEntity<Note> {
        val savedNote = noteService.saveNote(note)
        return ResponseEntity.ok(savedNote)
    }

    @PutMapping("/{id}")
    fun updateNote(@PathVariable id: Int, @RequestBody updatedNote: Note): ResponseEntity<Note> {
        val updated = noteService.updateNote(id, updatedNote)
        return ResponseEntity.ok(updated)
    }

    @DeleteMapping("/{id}")
    fun deleteNote(@PathVariable id: Int): ResponseEntity<Void> {
        noteService.deleteNote(id)
        return ResponseEntity.noContent().build()
    }
}
