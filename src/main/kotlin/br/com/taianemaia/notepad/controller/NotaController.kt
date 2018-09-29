package br.com.taianemaia.notepad.controller

import br.com.taianemaia.notepad.model.Nota
import br.com.taianemaia.notepad.service.NotaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/nota")

class NotaController {

    @Autowired
    lateinit var notaService: NotaService

    @GetMapping("/check")
    fun checkHealth() : String {
        return "OK";
    }

    @GetMapping
    fun findAll(): List<Nota> {
        return notaService.findAll()
    }

    @PostMapping
    fun save(@RequestBody nota: Nota): Nota {
        return notaService.save(nota)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String) {
        notaService.delete(id)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: String): Nota {
        return notaService.findById(id)
    }

    @GetMapping("/titulo/{titulo}")
    fun findByTitulo(@PathVariable("titulo") titulo: String): List<Nota> {
        return notaService.findByTituloContainingIgnoreCase(titulo)
    }
}