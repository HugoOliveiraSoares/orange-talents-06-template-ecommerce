package br.com.zupacademy.hugo.mercadolivre.controller.dto;

public class FieldErrorOutputDto {

    private String field;
    private String message;

    FieldErrorOutputDto() { }

    public FieldErrorOutputDto(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
