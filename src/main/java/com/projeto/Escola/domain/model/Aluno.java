package com.projeto.Escola.domain.model;

import javax.persistence.*;

@Entity //Diz ao BD que é uma Entidade (tabela)
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "nome", length = 50) //@Column indica que é uma coluna/atributo do BD
    private String nome;

    @Column(nullable = false, name = "ra", length = 50)
    private String ra;

    @Column(nullable = false, name = "rg", length = 50)
    private String rg;

    @Column(nullable = false, name = "cpf", length = 50)
    private String cpf;

}
