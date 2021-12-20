package com.projeto.escola.api;

import com.projeto.escola.domain.event.RecursoCriadoEvent;
import com.projeto.escola.domain.model.Turma;
import com.projeto.escola.domain.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@RequestMapping(path = "/turma", produces = MediaType.APPLICATION_JSON_VALUE)
public class TurmaController {
    //Acesso a camada de serviço
    private TurmaService turmaService;

    private ApplicationEventPublisher publisher;

    @Autowired
    public TurmaController(TurmaService turmaService, ApplicationEventPublisher publisher){
        this.turmaService = turmaService;
        this.publisher = publisher;
    }



    @PostMapping("/cadastrar")
    public ResponseEntity<Turma> salvar(@Validated @RequestBody Turma turma, HttpServletResponse response){
        Turma t = turmaService.salvarTurma(turma); // Grava uma turma no BD
        publisher.publishEvent(new RecursoCriadoEvent(this, response, t.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(t);
    }
}
