package br.com.zupacademy.hugo.mercadolivre.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Size(min = 1)
    private String linkImage;
    @NotNull @OneToOne @Valid
    private Product product;

    @Deprecated
    public Images() {
    }

    public Images(String linkImage, Product product) {
        this.linkImage = linkImage;
        this.product = product;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public Product getProduct() {
        return product;
    }
}
