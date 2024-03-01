package com.example.bibliotecaabc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_autores", schema = "public")
public class Autor extends AbstractEntity{

    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "idade")
    private int idade;

    @ManyToMany(mappedBy = "autores")
    private List<Livro> livros;
}
