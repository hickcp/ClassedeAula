package com.projeto.escola.domain.model;


import javax.persistence.*;

@Entity //Diz ao BD que é uma Entidade (tabela)
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "nome", length = 50)
    private String nome;
    @Column(nullable = false, name = "ra", length = 50)
    private String ra;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turma;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa(){return ra;}

    public void setRa(String ra){this.ra = ra;}

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
