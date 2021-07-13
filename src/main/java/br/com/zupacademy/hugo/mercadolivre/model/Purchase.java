package br.com.zupacademy.hugo.mercadolivre.model;

import br.com.zupacademy.hugo.mercadolivre.enums.Gateway;
import br.com.zupacademy.hugo.mercadolivre.enums.StatusPayment;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotEmpty
    private String item;
    @Positive
    private int quant;
    @NotNull @ManyToOne
    private Product product;
    @NotNull @ManyToOne
    private User buyer;
    @Enumerated @NotNull
    private Gateway gateway;
    private LocalDateTime instatCreation = LocalDateTime.now();

    @Deprecated
    public Purchase() {
    }

    public Purchase(Product product, int quant, User buyer, Gateway gateway) {
        this.item = product.getName();
        this.quant = quant;
        this.product = product;
        this.buyer = buyer;
        this.gateway = gateway;
    }

    public Long getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public int getQuant() {
        return quant;
    }

    public Product getProduct() {
        return product;
    }

    public User getBuyer() {
        return buyer;
    }

    public Gateway getGateway() {
        return gateway;
    }

    public LocalDateTime getInstatCreation() {
        return instatCreation;
    }

    public String redirectURI(UriComponentsBuilder uriComponentsBuilder){

        return this.gateway.createURI(this, uriComponentsBuilder);
    }

}
