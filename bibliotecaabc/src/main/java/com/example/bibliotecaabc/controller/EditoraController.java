package com.example.bibliotecaabc.controller;

import com.example.bibliotecaabc.entity.Autor;
import com.example.bibliotecaabc.entity.Editora;
import com.example.bibliotecaabc.service.AutorService;
import com.example.bibliotecaabc.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/editora")
public class EditoraController {

    @Autowired
    private EditoraService service;

    @GetMapping
    public ResponseEntity<Editora> findById(@RequestParam Long id)
    {
        try {
            Editora editora = this.service.findById(id);
            return new ResponseEntity<>(editora, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Editora>> listAll(){
        try {
            List<Editora> lista = this.service.listAll();
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Editora editora)
    {
        try {
            String mensagem = this.service.save(editora);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestParam Long id ,@RequestBody Editora editora)
    {
        try {
            String mensagem = this.service.update(id, editora);
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
