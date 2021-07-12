package br.com.zupacademy.hugo.mercadolivre.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
    @Enumerated @NotNull
    private StatusPurchase statusPurchase;

    public Purchase(Product product, int quant, User buyer, Gateway gateway, StatusPurchase statusPurchase) {
        this.item = product.getName();
        this.quant = quant;
        this.product = product;
        this.buyer = buyer;
        this.gateway = gateway;
        this.statusPurchase = statusPurchase;
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

    public StatusPurchase getStatusPurchase() {
        return statusPurchase;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "item='" + item + '\'' +
                ", quant=" + quant +
                ", product=" + product.getName() +
                ", buyer=" + buyer.getEmail() +
                ", gateway=" + gateway +
                '}';
    }

}
