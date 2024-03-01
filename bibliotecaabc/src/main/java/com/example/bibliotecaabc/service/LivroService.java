package com.example.bibliotecaabc.service;

import com.example.bibliotecaabc.entity.Livro;
import com.example.bibliotecaabc.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository ;

    public Livro findById(Long id)
    {
        Livro livro = this.repository.findById(id).orElseThrow(() -> new RuntimeException("não encontrado"));
        return livro;
    }

    public List<Livro> listAll(){

        List<Livro> lista = this.repository.findAll();
        if(lista.isEmpty())
        {
            throw new RuntimeException("lista vazia");
        }
        return lista;
    }

    public String save(Livro livro)
    {
        this.repository.save(livro);
        return livro.getTitulo() + " salvo com sucesso";
    }

    public String update(Long id, Livro livro)
    {
        Livro livroId = this.repository.findById(id).orElseThrow(() -> new RuntimeException("não encontrado"));
        if(id != livro.getId())
        {
            throw  new RuntimeException("ID não coincidem");
        }
        this.repository.save(livro);
        return livro.getTitulo() + " alterado com sucesso";
    }

    public String delete(Long id)
    {
        Livro livro = this.repository.findById(id).orElseThrow(() -> new RuntimeException("não encontrado"));
        this.repository.deleteById(id);
        return "Deletado com sucesso";


    }

}
