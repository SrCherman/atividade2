package com.example.bibliotecaabc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "tb_livros", schema = "public")
public class Livro extends AbstractEntity {

    @Column(name = "issn")
    private String issn;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "sinopse")
    private String sinopse;
    @Column(name = "ano")
    private int ano;
    @Column(name = "paginas")
    private int paginas;
    @ManyToOne
    @JoinColumn(name = "biblioteca_id")
    @JsonIgnoreProperties("livros")
    private Biblioteca biblioteca;

    @ManyToMany
    @JoinTable(
            name = "tb_livro_autor",
            joinColumns = @JoinColumn(name = "livro_id_fk"),
            inverseJoinColumns = @JoinColumn(name = "autor_id_fk")
    )
    @JsonIgnoreProperties("livros")
    private List<Autor> autores;

    @ManyToOne
    @JoinColumn(name = "editora_id")
    @JsonIgnoreProperties("livros")
    private Editora editora;
}
