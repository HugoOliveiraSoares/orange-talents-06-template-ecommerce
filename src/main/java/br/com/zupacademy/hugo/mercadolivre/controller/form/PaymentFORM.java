package br.com.zupacademy.hugo.mercadolivre.controller.form;

import br.com.zupacademy.hugo.mercadolivre.model.Payment;
import br.com.zupacademy.hugo.mercadolivre.enums.StatusPayment;
import br.com.zupacademy.hugo.mercadolivre.model.Purchase;
import javax.validation.constraints.NotNull;

public class PaymentFORM {

    private String gatewayId;
    @NotNull
    private StatusPayment status;

    public String getGatewayId() {
        return gatewayId;
    }

    public StatusPayment getStatus() {
        return status;
    }

    public Payment convert(Purchase purchase) {
        return new Payment(purchase, this.gatewayId, this.status);
    }
}
