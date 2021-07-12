package br.com.zupacademy.hugo.mercadolivre.model;

import br.com.zupacademy.hugo.mercadolivre.controller.form.FeaturesFORM;
import io.jsonwebtoken.lang.Assert;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotEmpty
    private String name;
    @NotNull @Positive
    private Integer price;
    @NotNull @Positive
    private Integer quantity;
    @NotNull @NotEmpty @Length(max = 1000)
    private String description;
    @NotNull @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST) @Size(min = 3)
    private Set<Features> features = new HashSet<>();
    @NotNull @ManyToOne
    private Category category;
    private LocalDateTime instant = LocalDateTime.now();
    @NotNull @Valid @ManyToOne
    private User owner;

    @Deprecated
    public Product() {
    }

    public Product(@Valid String name, Integer price, Integer quantity, String description, Collection<FeaturesFORM> features, Category category, User owner) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
        this.features.addAll( features.stream().map(feature -> feature.convert(this)).collect(Collectors.toSet()) );
        this.owner = owner;
    }

    public boolean isOwner(User owner) {
        return this.owner.equals(owner);
    }

    public boolean destock(@Positive int quantity){
        Assert.isTrue(quantity > 0, "A quantidade deve ser maior do que 0");

        if (this.quantity >= quantity) {
            this.quantity -= quantity;
            return true;
        }
        return false;
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

    public Set<Features> getFeatures() {
        return features;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDateTime getInstant() {
        return instant;
    }

    public User getOwner() {
        return owner;
    }
}
