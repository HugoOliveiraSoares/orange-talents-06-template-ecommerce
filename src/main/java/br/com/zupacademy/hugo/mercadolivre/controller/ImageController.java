package br.com.zupacademy.hugo.mercadolivre.controller;

import br.com.zupacademy.hugo.mercadolivre.controller.form.ImagesFORM;
import br.com.zupacademy.hugo.mercadolivre.model.Images;
import br.com.zupacademy.hugo.mercadolivre.model.Product;
import br.com.zupacademy.hugo.mercadolivre.model.User;
import br.com.zupacademy.hugo.mercadolivre.repository.ImageRepository;
import br.com.zupacademy.hugo.mercadolivre.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product/{id}/images")
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<?> register(@PathVariable Long id, @Valid ImagesFORM imagesFORM,
                                      @AuthenticationPrincipal User owner){

        Optional<Product> product = productRepository.findById(id);
        System.out.println(owner.getEmail());

        if (product.isPresent()){

            if (!product.get().isOwner(owner)) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN);
            }

            List<Images> images = imagesFORM.convert(product.get());
            imageRepository.saveAll(images);

            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
