package com.curso.app.curso.controller;

import com.curso.app.curso.dto.CursoDto;
import com.curso.app.curso.model.Curso;
import com.curso.app.curso.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CursoController.PATH)
public class CursoController {

  public static final String PATH = "/curso";

  @Autowired
  private CursoService cursoService;

  @PostMapping("/")
  public ResponseEntity<Curso> adicionarCurso(@RequestBody CursoDto cursoDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.adicionarCurso(cursoDto));
  }

  @GetMapping()
  public ResponseEntity<List<Curso>> listarCurso() {
    return ResponseEntity.ok().body(cursoService.listarCurso());
  }

  @GetMapping("/id")
  public ResponseEntity<Curso> buscarCurso(@RequestParam Integer id) {
    return ResponseEntity.ok().body(cursoService.buscarCurso(id));
  }

  @PutMapping()
  public ResponseEntity<Curso> atualizarCurso(@RequestParam Integer id, @RequestBody CursoDto cursoDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.atualizarCurso(id, cursoDto));
  }

  @PatchMapping("/active")
  public ResponseEntity<Boolean> activeCurso(@RequestParam Integer id) {
    return ResponseEntity.ok().body(cursoService.activeCurso(id));
  }

}
