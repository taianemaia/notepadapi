package br.com.taianemaia.notepad.repository

import br.com.taianemaia.notepad.model.Nota
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface NotaRepository : MongoRepository<Nota, String> {

    fun findByTituloContainingIgnoreCase(titulo: String): List<Nota>
}