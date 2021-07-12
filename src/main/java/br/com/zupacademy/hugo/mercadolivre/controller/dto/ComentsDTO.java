package br.com.zupacademy.hugo.mercadolivre.controller.dto;

import br.com.zupacademy.hugo.mercadolivre.model.Coments;

public class ComentsDTO {

    private Integer note;
    private String title;
    private String description;
    private String user;

    public ComentsDTO(Coments coments) {
        this.note = coments.getNote();
        this.title = coments.getTitle();
        this.description = coments.getDescription();
        this.user = coments.getUser().getEmail();
    }

    public Integer getNote() {
        return note;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUser() {
        return user;
    }
}
