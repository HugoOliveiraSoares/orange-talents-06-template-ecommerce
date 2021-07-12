package br.com.zupacademy.hugo.mercadolivre.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Coments {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(1) @Max(5)
    private Integer note;
    @NotNull @NotEmpty
    private String title;
    @NotNull @NotEmpty @Length(max = 500)
    private String description;
    @NotNull @ManyToOne
    private User user;
    @NotNull @ManyToOne @Valid
    private Product product;

    @Deprecated
    public Coments() {
    }

    public Coments(@Valid Integer note, String title, String description, User user, Product product) {
        this.note = note;
        this.title = title;
        this.description = description;
        this.user = user;
        this.product = product;

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

    public User getUser() {
        return user;
    }
}
