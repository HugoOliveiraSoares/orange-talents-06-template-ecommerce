package br.com.zupacademy.hugo.mercadolivre.controller.form;

import br.com.zupacademy.hugo.mercadolivre.model.Coments;
import br.com.zupacademy.hugo.mercadolivre.model.Product;
import br.com.zupacademy.hugo.mercadolivre.model.User;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ComentsFORM {

    @Min(1) @Max(5)
    private Integer note;
    @NotNull @NotEmpty
    private String title;
    @NotNull @NotEmpty @Length(max = 500)
    private String description;

    public ComentsFORM(Integer note, String title, String description) {
        this.note = note;
        this.title = title;
        this.description = description;
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

    public Coments convert(Product product, User user) {
        return new Coments(this.note, this.title, this.description, user, product);
    }
}
