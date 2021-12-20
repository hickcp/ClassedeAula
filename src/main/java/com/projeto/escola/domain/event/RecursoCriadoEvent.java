package com.projeto.escola.domain.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class RecursoCriadoEvent extends ApplicationEvent {
    private static long serialVersionUID = 1L;

    private HttpServletResponse response; // varial response do tipo httpservlet
    private Long codigo;


    public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo){ //CONSTRUTOR PARA RETORNAR UMA MENSAGEM HTTP.
        super(source); //classe pai
        this.response = response;
        this.codigo = codigo;

    }

    public HttpServletResponse getResponse(){ return response;}

    public Long getCodigo(){return codigo;}
}
