package com.curso.app.exception;

public class CursoNotFoundException extends RuntimeException {

  private Integer id;

  public CursoNotFoundException(int id) {
    this.id = id;
  }

  @Override
  public String getMessage() {
    return "O curso id: " + id + " não foi encontrado.";
  }
}
