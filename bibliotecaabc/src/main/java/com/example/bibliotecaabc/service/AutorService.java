package com.example.bibliotecaabc.service;

import com.example.bibliotecaabc.entity.Autor;
import com.example.bibliotecaabc.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository ;

    public Autor findById(Long id)
    {
        Autor autor = this.repository.findById(id).orElseThrow(() -> new RuntimeException("não encontrado"));
        return autor;
    }

    public List<Autor> listAll(){

        List<Autor> lista = this.repository.findAll();
        if(lista.isEmpty())
        {
            throw new RuntimeException("lista vazia");
        }
        return lista;
    }

    public String save(Autor autor)
    {
        this.repository.save(autor);
        return autor.getNome() + " salvo com sucesso";
    }

    public String update(Long id, Autor autor)
    {
        Autor autorId = this.repository.findById(id).orElseThrow(() -> new RuntimeException("não encontrado"));
        if(id != autor.getId())
        {
            throw  new RuntimeException("ID não coincidem");
        }
        this.repository.save(autor);
        return autor.getNome() + " alterado com sucesso";
    }

    public String delete(Long id)
    {
        Autor autor = this.repository.findById(id).orElseThrow(() -> new RuntimeException("não encontrado"));
        this.repository.deleteById(id);
        return "Deletado com sucesso";


    }

}
