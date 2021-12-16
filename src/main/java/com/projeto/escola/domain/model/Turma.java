package com.projeto.escola.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity //Uma entidade (tabela)
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gera automaticamenteo  ID
    private Long id;

    @Column(nullable = false, name = "turma", length = 10)
    private String turma;

    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;

    @JsonIgnoreProperties("aluno")
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true) // Indica ao BD que é um (classe) para muitos (alunos)
    private List<Aluno> alunos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }


}
