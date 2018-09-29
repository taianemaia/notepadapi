package br.com.taianemaia.notepad.service

import br.com.taianemaia.notepad.model.Nota
import br.com.taianemaia.notepad.repository.NotaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NotaService {

    @Autowired
    lateinit var notaRepository: NotaRepository

    fun save(nota: Nota): Nota {
        return notaRepository.save(nota)
    }

    fun findAll() : List<Nota> {
        return notaRepository.findAll()
    }

    fun delete(id: String) {
        notaRepository.deleteById(id)
    }

    fun findById(id: String): Nota {
        return notaRepository.findById(id).get()
    }

    fun findByTituloContainingIgnoreCase(titulo: String): List<Nota> {
        return notaRepository.findByTituloContainingIgnoreCase(titulo)
    }

}