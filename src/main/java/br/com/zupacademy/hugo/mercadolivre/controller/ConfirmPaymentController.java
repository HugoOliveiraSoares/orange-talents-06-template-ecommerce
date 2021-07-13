package br.com.zupacademy.hugo.mercadolivre.controller;

import br.com.zupacademy.hugo.mercadolivre.components.Mailer;
import br.com.zupacademy.hugo.mercadolivre.controller.form.PaymentFORM;
import br.com.zupacademy.hugo.mercadolivre.enums.StatusPayment;
import br.com.zupacademy.hugo.mercadolivre.model.Payment;
import br.com.zupacademy.hugo.mercadolivre.model.Purchase;
import br.com.zupacademy.hugo.mercadolivre.repository.PaymentRepository;
import br.com.zupacademy.hugo.mercadolivre.repository.PurchaseRepository;
import br.com.zupacademy.hugo.mercadolivre.validation.UniquePayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ConfirmPaymentController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private Mailer mailer;

    @Autowired
    private UniquePayment uniquePayment;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(uniquePayment);
    }

    @PostMapping("/pagseguro/{id}")
    public ResponseEntity<?> pagseguroProcessor(@PathVariable Long id, @RequestBody @Valid PaymentFORM form){

        Optional<Purchase> purchase = purchaseRepository.findById(id);

        if (purchase.isEmpty())
            return ResponseEntity.notFound().build();

        Payment payment = form.convert(purchase.get());

        StatusPayment status = payment.processing(purchase.get(), mailer);

        paymentRepository.save(payment);

        return ResponseEntity.ok().body(status);
    }

    @PostMapping("/paypal/{id}")
    public ResponseEntity<?> paypalProcessor(@PathVariable Long id, @RequestBody @Valid PaymentFORM form){

        Optional<Purchase> purchase = purchaseRepository.findById(id);

        if (purchase.isEmpty())
            return ResponseEntity.notFound().build();

        Payment payment = form.convert(purchase.get());

        StatusPayment status = payment.processing(purchase.get(), mailer);

        paymentRepository.save(payment);

        return ResponseEntity.ok().body(status);
    }
}
