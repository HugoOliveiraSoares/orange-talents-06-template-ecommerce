package br.com.zupacademy.hugo.mercadolivre.validation;

import br.com.zupacademy.hugo.mercadolivre.controller.form.PaymentFORM;
import br.com.zupacademy.hugo.mercadolivre.enums.StatusPayment;
import br.com.zupacademy.hugo.mercadolivre.model.Payment;
import br.com.zupacademy.hugo.mercadolivre.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UniquePayment implements Validator {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return PaymentFORM.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors())
            return;

        PaymentFORM payment = (PaymentFORM) o;
        Optional<Payment> possiblePayment = paymentRepository.findByGatewayIdAndStatus(payment.getGatewayId(), StatusPayment.SUCESSO);

        if (possiblePayment.isPresent())
            errors.rejectValue("status", "Pagamento já registrado");

    }
}
