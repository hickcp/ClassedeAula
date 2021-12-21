package com.projeto.escola.domain.model;


import javax.persistence.*;

@Entity //Diz ao BD que é uma Entidade (tabela)
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "nome", length = 50)
    private String aluno_nome;

    @Column(nullable = false, name = "ra", length = 50)
    private String aluno_ra;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turma;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAluno_nome() {
        return aluno_nome;
    }

    public void setAluno_nome(String aluno_nome) {
        this.aluno_nome = aluno_nome;
    }

    public String getAluno_ra(){return aluno_ra;}

    public void setAluno_ra(String aluno_ra){this.aluno_ra = aluno_ra;}

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
