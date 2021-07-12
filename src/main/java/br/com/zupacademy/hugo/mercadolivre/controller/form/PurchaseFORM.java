package br.com.zupacademy.hugo.mercadolivre.controller.form;

import br.com.zupacademy.hugo.mercadolivre.model.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PurchaseFORM {

    @NotNull @NotEmpty
    private String item;
    @Positive
    private int quant;
    @NotNull
    private Gateway gateway;

    public PurchaseFORM(String item, int quant, Gateway gateway) {
        this.item = item;
        this.quant = quant;
        this.gateway = gateway;
    }

    public Purchase convert(Product product, User buyer){

        return new Purchase(product, this.quant, buyer, this.getGateway(), StatusPurchase.INICIADA);

    }

    public String getItem() {
        return item;
    }

    public int getQuant() {
        return quant;
    }

    public Gateway getGateway() {
        return gateway;
    }

    @Override
    public String toString() {
        return "PurchaseFORM{" +
                "item='" + item + '\'' +
                ", quant=" + quant +
                '}';
    }
}
