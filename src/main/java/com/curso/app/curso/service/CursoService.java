package com.curso.app.curso.service;

import com.curso.app.curso.dto.CursoDto;
import com.curso.app.curso.model.Curso;
import com.curso.app.curso.repository.CursoRepository;
import com.curso.app.exception.CursoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

  @Autowired
  private CursoRepository cursoRepository;

  public Curso adicionarCurso(CursoDto cursoDto) {
    Curso curso = Curso.builder()
            .name(cursoDto.getName())
            .categoria(cursoDto.getCategoria())
            .active(true)
            .created_at(LocalDateTime.now())
            .build();

    return this.cursoRepository.save(curso);
  }

  public List<Curso> listarCurso() {
    return cursoRepository.findAll();
  }

  public Curso buscarCurso(Integer id) {
    Optional<Curso> encontrarCurso = this.cursoRepository.findById(id);

    if (encontrarCurso.isPresent()) {
      return encontrarCurso.get();
    } else {
      throw new CursoNotFoundException(id);
    }
  }

  public Curso atualizarCurso(Integer id, CursoDto cursoDto) {
    Optional<Curso> encontrarCurso = this.cursoRepository.findById(id);
    Curso curso = null;

    if (encontrarCurso.isPresent()) {
      curso = encontrarCurso.get();
      curso.setName(cursoDto.getName());
      curso.setCategoria(cursoDto.getCategoria());
      curso.setUpdated_at(LocalDateTime.now());

      return this.cursoRepository.save(curso);
    } else {
      throw new CursoNotFoundException(id);
    }
  }

  public void deletarCurso(Integer id) {
    Optional<Curso> encontarCurso = this.cursoRepository.findById(id);

    if (encontarCurso.isPresent()) {
      this.cursoRepository.deleteById(id);
    } else {
      throw new CursoNotFoundException(id);
    }
  }

  public boolean activeCurso(Integer id) {
    Optional<Curso> encontrarCurso = this.cursoRepository.findById(id);
    Curso curso = null;

    if (encontrarCurso.isPresent()) {
      curso = encontrarCurso.get();

      if (curso.isActive()) {
        curso.setActive(false);
      } else {
        curso.setActive(true);
      }

      this.cursoRepository.save(curso);

      return curso.isActive();
    } else {
      throw new CursoNotFoundException(id);
    }
  }

}
