package com.curso.app.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public enum Categoria {

  PRESENCIAL(0), HIBRIDO(1), EAD(2);

  private int id;

  public static Categoria get(int id) {
    Categoria output = PRESENCIAL;

    for (Categoria cat : Categoria.values()) {
      if (cat.id == id) {
        output = cat;
      }
    }

    return output;
  }
}
