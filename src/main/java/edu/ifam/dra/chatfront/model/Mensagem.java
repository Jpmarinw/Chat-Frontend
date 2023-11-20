package edu.ifam.dra.chatfront.model;

import jakarta.validation.constraints.NotBlank;

public class Mensagem {
	
    private Long id;

    @NotBlank
    private String conteudo;

    @NotBlank
    private String emissor;

    @NotBlank
    private String receptor;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getEmissor() {
        return emissor;
    }

    public void setEmissor(String emissor) {
        this.emissor = emissor;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }


}
