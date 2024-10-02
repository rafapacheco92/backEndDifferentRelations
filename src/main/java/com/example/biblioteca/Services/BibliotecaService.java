package com.example.biblioteca.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.Dtos.req.CreateBibliotecaDTO;
import com.example.biblioteca.Dtos.req.CreateLivroDTO;
import com.example.biblioteca.Dtos.res.ShowAutorDTO;
import com.example.biblioteca.Dtos.res.ShowBibliotecaDTO;
import com.example.biblioteca.Dtos.res.ShowLivroDTO;
import com.example.biblioteca.Entities.AutorEntity;
import com.example.biblioteca.Entities.BibliotecaEntity;
import com.example.biblioteca.Entities.LivroEntity;
import com.example.biblioteca.Repositories.AutorRepository;
import com.example.biblioteca.Repositories.BibliotecaRepository;
import com.example.biblioteca.Repositories.LivroRepository;

@Service
public class BibliotecaService {

  @Autowired
  private BibliotecaRepository bibliotecaRepository;

  @Autowired
  private LivroRepository livroRepository;

  @Autowired
  private AutorRepository autorRepository;

  public void createBiblioteca(CreateBibliotecaDTO dto) {

    BibliotecaEntity biblioteca = new BibliotecaEntity();
    biblioteca.setNome(dto.getNome());

    biblioteca = bibliotecaRepository.save(biblioteca);

    List<LivroEntity> livros = new ArrayList<>();
    for (CreateLivroDTO livroDTO : dto.getLivros()) {
      LivroEntity livro = new LivroEntity();
      livro.setTitulo(livroDTO.getTitulo());
      livro.setBiblioteca(biblioteca);

      livro = livroRepository.save(livro);

      AutorEntity autor = new AutorEntity();
      autor.setNome(livroDTO.getAutor().getNome());
      autor.setNacionalidade(livroDTO.getAutor().getNacionalidade());
      autor.setLivro(livro);

      autorRepository.save(autor);

      livros.add(livro);
    }

    biblioteca.setLivros(livros);
  }

  public List<ShowBibliotecaDTO> getBibliotecas() {
    List<BibliotecaEntity> bibliotecas = bibliotecaRepository.findAll();

    return bibliotecas.stream().map(biblioteca -> {
      ShowBibliotecaDTO bibliotecaDTO = new ShowBibliotecaDTO();
      List<ShowLivroDTO> livrosDTO = new ArrayList<>();

      for (LivroEntity livro : biblioteca.getLivros()) {
        ShowLivroDTO livroDTO = new ShowLivroDTO();
        livroDTO.setId(livro.getId());
        livroDTO.setTitulo(livro.getTitulo());

        ShowAutorDTO autorDTO = new ShowAutorDTO();
        autorDTO.setNome(livro.getAutor().getNome());
        autorDTO.setNacionalidade(livro.getAutor().getNacionalidade());

        livroDTO.setAutor(autorDTO);
        livrosDTO.add(livroDTO);
      }

      bibliotecaDTO.setId(biblioteca.getId());
      bibliotecaDTO.setNome(biblioteca.getNome());
      bibliotecaDTO.setLivros(livrosDTO);

      return bibliotecaDTO;
    }).toList();
  }
}
