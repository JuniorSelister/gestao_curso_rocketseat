package com.curso.app.curso.model;

import com.curso.app.util.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "CURSO")
@Table(name = "CURSO")
public class Curso {

  @Id
  @GeneratedValue(generator = "SEQUENCE_CURSO_ID")
  @SequenceGenerator(name = "SEQUENCE_CURSO_ID", sequenceName = "SEQUENCE_CURSO_ID", allocationSize = 1)
  @Column(name = "ID")
  private Integer id;

  @Column(name = "NOME")
  private String name;

  @Column(name = "CATEGORIA")
  private Categoria categoria;

  @Column(name = "ACTIVE")
  private boolean active;

  @Column(name = "CREATED_AT")
  private LocalDateTime created_at;

  @Column(name = "UPDATED_AT")
  private LocalDateTime updated_at;

}
