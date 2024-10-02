package com.example.biblioteca.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "bibliotecas")
public class BibliotecaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nome")
  private String nome;

  @OneToMany(mappedBy = "biblioteca")
  private List<LivroEntity> livros;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<LivroEntity> getLivros() {
    return livros;
  }

  public void setLivros(List<LivroEntity> livros) {
    this.livros = livros;
  }

}
