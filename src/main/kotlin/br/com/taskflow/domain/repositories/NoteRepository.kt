package br.com.taskflow.domain.repositories

import br.com.taskflow.domain.entities.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NoteRepository : JpaRepository<Note, Long> {

    fun findAllByOrderByPriorityDesc(): List<Note>

    override fun deleteById(noteId: Long)

    override fun deleteAll()
}