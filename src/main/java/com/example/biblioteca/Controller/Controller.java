package com.example.biblioteca.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.Dtos.req.CreateBibliotecaDTO;
import com.example.biblioteca.Dtos.res.ShowBibliotecaDTO;
import com.example.biblioteca.Services.BibliotecaService;

@RestController
@RequestMapping("/bibliotecas")
public class Controller {

  @Autowired
  private BibliotecaService bibliotecaService;

  @PostMapping
  public ResponseEntity<?> createBiblioteca(@RequestBody CreateBibliotecaDTO dto) {

    bibliotecaService.createBiblioteca(dto);

    return ResponseEntity.status(201).build();
  }

  @GetMapping
  public ResponseEntity<List<ShowBibliotecaDTO>> getAllBibliotecas() {

    List<ShowBibliotecaDTO> bibliotecas = bibliotecaService.getBibliotecas();

    return ResponseEntity.status(200).body(bibliotecas);
  }
}
