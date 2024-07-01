package com.curso.app.curso.dto;

import com.curso.app.util.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CursoDto {

  private String name;
  private Categoria categoria;

}
