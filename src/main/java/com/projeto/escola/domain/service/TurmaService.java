package com.projeto.escola.domain.service;

import com.projeto.escola.domain.model.Turma;
import com.projeto.escola.domain.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Regra de negócio
public class TurmaService { //Serviços, onde é construido o get, put, post, etc
    // acesso ao repository
    private TurmaRepository turmaRepository;

    @Autowired
    public TurmaService(TurmaRepository turmaRepository){this.turmaRepository = turmaRepository;} //

    public Turma salvarTurma(Turma t){ // Salvar tipo Turma, recebe como parametro Turma t
        t.getAlunos().forEach(a -> a.setTurma(t)); //
        return turmaRepository.save(t); // salva
    }
}
