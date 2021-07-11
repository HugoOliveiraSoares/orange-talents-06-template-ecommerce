package br.com.zupacademy.hugo.mercadolivre.controller;

import br.com.zupacademy.hugo.mercadolivre.controller.form.ComentsFORM;
import br.com.zupacademy.hugo.mercadolivre.model.Coments;
import br.com.zupacademy.hugo.mercadolivre.model.Product;
import br.com.zupacademy.hugo.mercadolivre.model.User;
import br.com.zupacademy.hugo.mercadolivre.repository.ComentsRepository;
import br.com.zupacademy.hugo.mercadolivre.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("product/{id}/coments")
public class ComentsController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ComentsRepository comentsRepository;

    @PostMapping
    public ResponseEntity<?> register(@PathVariable Long id, @RequestBody @Valid ComentsFORM comentsFORM, @AuthenticationPrincipal User user){

        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty())
            return ResponseEntity.notFound().build();

        Coments coments = comentsFORM.convert(product.get(), user);

        comentsRepository.save(coments);

        return ResponseEntity.ok().build();
    }

}
