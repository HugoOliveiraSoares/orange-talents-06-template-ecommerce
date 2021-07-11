package br.com.zupacademy.hugo.mercadolivre.controller.form;


import br.com.zupacademy.hugo.mercadolivre.model.Category;
import br.com.zupacademy.hugo.mercadolivre.model.Features;
import br.com.zupacademy.hugo.mercadolivre.model.Product;
import br.com.zupacademy.hugo.mercadolivre.model.User;
import br.com.zupacademy.hugo.mercadolivre.repository.CategoryRepository;
import io.jsonwebtoken.lang.Assert;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductForm {

    @NotNull @NotEmpty
    private String name;
    @NotNull @Positive
    private int price;
    @NotNull @Positive
    private int quantity;
    @NotNull @NotEmpty
    private String description;
    @NotNull @Size(min = 3) @Valid
    private List<FeaturesFORM> features;
    @NotNull @NotEmpty
    private String category;


    public Product convert(CategoryRepository categoryRepository, User owner){

        Category category = categoryRepository.findByName(this.category);
        Assert.notNull(category, "Categoria não encontrada!");


        return new Product(this.name, this.price, this.quantity, this.description, this.features, category, owner);

    }

    public Set<String> getEqualsFeatures() {
        HashSet<String> equalName = new HashSet<>();
        HashSet<String> results = new HashSet<>();

        for (FeaturesFORM feature: features) {
            if (!equalName.add(feature.getName()))
                results.add(feature.getName());
        }
        return results;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public List<FeaturesFORM> getFeatures() {
        return features;
    }

    public String getCategory() {
        return category;
    }
}
