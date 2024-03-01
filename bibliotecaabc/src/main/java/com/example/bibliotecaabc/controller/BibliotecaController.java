package com.example.bibliotecaabc.controller;

import com.example.bibliotecaabc.entity.Biblioteca;
import com.example.bibliotecaabc.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/biblioteca")
public class BibliotecaController {

    @Autowired
    private BibliotecaService service;

    @GetMapping
    public ResponseEntity<Biblioteca> findById(@RequestParam Long id)
    {
        try {
            Biblioteca biblioteca = this.service.findById(id);
            return new ResponseEntity<>(biblioteca, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Biblioteca>> listAll(){
        try {
            List<Biblioteca> lista = this.service.listAll();
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Biblioteca biblioteca)
    {
        try {
            String mensagem = this.service.save(biblioteca);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestParam Long id ,@RequestBody Biblioteca biblioteca)
    {
        try {
            String mensagem = this.service.update(id, biblioteca);
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
