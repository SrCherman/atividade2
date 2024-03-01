package com.example.bibliotecaabc.service;

import com.example.bibliotecaabc.entity.Biblioteca;
import com.example.bibliotecaabc.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {

    @Autowired
    private BibliotecaRepository repository ;

    public Biblioteca findById(Long id)
    {
        Biblioteca biblioteca = this.repository.findById(id).orElseThrow(() -> new RuntimeException("não encontrado"));
        return biblioteca;
    }

    public List<Biblioteca> listAll(){

        List<Biblioteca> lista = this.repository.findAll();
        if(lista.isEmpty())
        {
            throw new RuntimeException("lista vazia");
        }
        return lista;
    }

    public String save(Biblioteca biblioteca)
    {
        this.repository.save(biblioteca);
        return biblioteca.getNome() + " salvo com sucesso";
    }

    public String update(Long id, Biblioteca biblioteca)
    {
        Biblioteca bibliotecaId = this.repository.findById(id).orElseThrow(() -> new RuntimeException("não encontrado"));
        if(id != biblioteca.getId())
        {
            throw  new RuntimeException("ID não coincidem");
        }
        this.repository.save(biblioteca);
        return biblioteca.getNome() + " alterado com sucesso";
    }

    public String delete(Long id)
    {
        Biblioteca biblioteca = this.repository.findById(id).orElseThrow(() -> new RuntimeException("não encontrado"));
        this.repository.deleteById(id);
        return "Deletado com sucesso";


    }
}
