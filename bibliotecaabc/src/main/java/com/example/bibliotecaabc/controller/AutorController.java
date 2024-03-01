package com.example.bibliotecaabc.controller;

import com.example.bibliotecaabc.entity.Autor;
import com.example.bibliotecaabc.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/autor")
public class AutorController {

    @Autowired
    private AutorService service;

    @GetMapping
    public ResponseEntity<Autor> findById(@RequestParam Long id)
    {
        try {
            Autor autor = this.service.findById(id);
            return new ResponseEntity<>(autor, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Autor>> listAll(){
        try {
            List<Autor> lista = this.service.listAll();
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Autor autor)
    {
        try {
            String mensagem = this.service.save(autor);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestParam Long id ,@RequestBody Autor autor)
    {
        try {
            String mensagem = this.service.update(id, autor);
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
