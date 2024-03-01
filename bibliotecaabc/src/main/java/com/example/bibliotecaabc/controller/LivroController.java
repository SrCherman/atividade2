package com.example.bibliotecaabc.controller;

import com.example.bibliotecaabc.entity.Livro;
import com.example.bibliotecaabc.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/livro")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping
    public ResponseEntity<Livro> findById(@RequestParam Long id)
    {
        try {
            Livro livro = this.service.findById(id);
            return new ResponseEntity<>(livro, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Livro>> listAll(){
        try {
            List<Livro> lista = this.service.listAll();
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Livro livro)
    {
        try {
            String mensagem = this.service.save(livro);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestParam Long id ,@RequestBody Livro livro)
    {
        try {
            String mensagem = this.service.update(id, livro);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Long id)
    {
        try {
            String mensagem = this.service.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
