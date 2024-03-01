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
@Table(name = "tb_editoras", schema = "public")
public class Editora extends AbstractEntity{

    @Column(name = "nome")
    private String nome;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "telefone")
    private String telefone;
    @OneToMany(mappedBy = "editora", cascade = CascadeType.ALL)
    private List<Livro> livros;
}
