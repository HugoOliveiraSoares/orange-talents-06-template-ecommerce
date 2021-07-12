package br.com.zupacademy.hugo.mercadolivre.controller;

import br.com.zupacademy.hugo.mercadolivre.components.Mailer;
import br.com.zupacademy.hugo.mercadolivre.controller.form.PurchaseFORM;
import br.com.zupacademy.hugo.mercadolivre.model.Gateway;
import br.com.zupacademy.hugo.mercadolivre.model.Product;
import br.com.zupacademy.hugo.mercadolivre.model.Purchase;
import br.com.zupacademy.hugo.mercadolivre.model.User;
import br.com.zupacademy.hugo.mercadolivre.repository.ProductRepository;
import br.com.zupacademy.hugo.mercadolivre.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/buy")
public class PurchaseController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private Mailer mailer;

    @PostMapping
    public ResponseEntity<?> buy(@RequestBody @Valid PurchaseFORM purchaseFORM,
                                 @AuthenticationPrincipal User buyer, UriComponentsBuilder uriComponentsBuilder){

        Optional<Product> product = productRepository.findByName(purchaseFORM.getItem());

        if (product.isEmpty())
            return ResponseEntity.notFound().build();

        boolean destock = product.get().destock(purchaseFORM.getQuant());
        if (!destock){
            return ResponseEntity.badRequest().build();
        }

        Purchase purchase = purchaseFORM.convert(product.get(), buyer);
        purchaseRepository.save(purchase);
        mailer.sendEmailPurchase(purchase.getProduct().getOwner().getEmail(), purchase.getBuyer().getEmail(), purchase.getStatusPurchase());

        if (purchase.getGateway().equals(Gateway.paypal)){
            String returnUri = uriComponentsBuilder.path("paypal").buildAndExpand(purchase.getId()).toString();
            String uri = "paypal.com?buyerId=" + purchase.getId() + "&redirectUrl="+returnUri;
            return ResponseEntity.ok().body(uri);

        }else {
            String returnUri = uriComponentsBuilder.path("pagseguro").buildAndExpand(purchase.getId()).toString();
            String uri = "pagseguro.com?buyerId=" + purchase.getId() + "&redirectUrl="+returnUri;
            return ResponseEntity.ok().body(uri);
        }

    }

}
