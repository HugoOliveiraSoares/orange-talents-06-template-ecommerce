package br.com.zupacademy.hugo.mercadolivre.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;

@Entity
public class Features {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty
    private String description;
    @ManyToOne
    private @NotNull @Valid Product product;

    @Deprecated
    public Features() {
    }

    public Features(@NotNull @NotEmpty String name, @NotNull @NotEmpty String description, Product product) {
        this.name = name;
        this.description = description;
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


}
