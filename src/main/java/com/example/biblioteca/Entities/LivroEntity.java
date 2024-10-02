package com.example.biblioteca.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity(name = "livros")
public class LivroEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "titulo")
  private String titulo;

  @ManyToOne
  @JoinColumn(name = "id_biblioteca")
  private BibliotecaEntity biblioteca;

  @OneToOne(mappedBy = "livro")
  private AutorEntity autor;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public AutorEntity getAutor() {
    return autor;
  }

  public void setAutor(AutorEntity autor) {
    this.autor = autor;
  }

  public BibliotecaEntity getBiblioteca() {
    return biblioteca;
  }

  public void setBiblioteca(BibliotecaEntity biblioteca) {
    this.biblioteca = biblioteca;
  }

}
