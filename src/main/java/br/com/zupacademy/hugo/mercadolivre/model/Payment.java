package br.com.zupacademy.hugo.mercadolivre.model;

import br.com.zupacademy.hugo.mercadolivre.components.Mailer;
import br.com.zupacademy.hugo.mercadolivre.enums.StatusPayment;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @OneToOne
    private Purchase purchase;
    @NotNull
    @NotEmpty
    private String gatewayId;
    @NotNull
    private StatusPayment status;
    private LocalDateTime instantCreation = LocalDateTime.now();

    @Deprecated
    public Payment() {
    }

    public Payment(Purchase purchase, String gatewayId, StatusPayment status) {
        this.purchase = purchase;
        this.gatewayId = gatewayId;
        this.status = status;
    }

    public StatusPayment processing(Purchase purchase, Mailer mailer){
        return this.status.process(purchase, mailer);
    }

    public Long getId() {
        return id;
    }

}
