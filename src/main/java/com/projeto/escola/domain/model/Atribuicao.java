package com.projeto.escola.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Atribuicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties("atribuicao")
    @OneToMany(mappedBy = "atribuicao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turma> turmas = new ArrayList<>();

    @JsonIgnoreProperties("atribuicao")
    @OneToMany(mappedBy = "atribuicao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Professor> profressores = new ArrayList<>();

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public List<Professor> getProfressores() {
        return profressores;
    }

    public void setProfressores(List<Professor> profressores) {
        this.profressores = profressores;
    }
}
