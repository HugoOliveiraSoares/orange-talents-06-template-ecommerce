package br.com.zupacademy.hugo.mercadolivre.controller.form;

import br.com.zupacademy.hugo.mercadolivre.model.Features;
import br.com.zupacademy.hugo.mercadolivre.model.Product;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FeaturesFORM {

    @NotNull
    @NotEmpty
    private String name;
    @NotNull @NotEmpty
    private String description;

    public FeaturesFORM(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Features convert(@NotNull @Valid Product product){
        return new Features(this.name, this.description, product);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
