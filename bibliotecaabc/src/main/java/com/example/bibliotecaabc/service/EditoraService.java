package com.example.bibliotecaabc.service;

import com.example.bibliotecaabc.entity.Editora;
import com.example.bibliotecaabc.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository repository ;

    public Editora findById(Long id)
    {
        Editora editora = this.repository.findById(id).orElseThrow(() -> new RuntimeException("não encontrado"));
        return editora;
    }

    public List<Editora> listAll(){

        List<Editora> lista = this.repository.findAll();
        if(lista.isEmpty())
        {
            throw new RuntimeException("lista vazia");
        }
        return lista;
    }

    public String save(Editora editora)
    {
        this.repository.save(editora);
        return editora.getNome() + " salvo com sucesso";
    }

    public String update(Long id, Editora editora)
    {
        Editora editoraId = this.repository.findById(id).orElseThrow(() -> new RuntimeException("não encontrado"));
        if(id != editora.getId())
        {
            throw  new RuntimeException("ID não coincidem");
        }
        this.repository.save(editora);
        return editora.getNome() + " alterado com sucesso";
    }

    public String delete(Long id)
    {
        Editora editora = this.repository.findById(id).orElseThrow(() -> new RuntimeException("não encontrado"));
        this.repository.deleteById(id);
        return "Deletado com sucesso";


    }
}
