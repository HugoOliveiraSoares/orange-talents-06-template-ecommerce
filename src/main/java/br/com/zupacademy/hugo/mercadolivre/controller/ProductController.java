package br.com.zupacademy.hugo.mercadolivre.controller;

import br.com.zupacademy.hugo.mercadolivre.controller.form.ProductForm;
import br.com.zupacademy.hugo.mercadolivre.model.Product;
import br.com.zupacademy.hugo.mercadolivre.model.User;
import br.com.zupacademy.hugo.mercadolivre.repository.CategoryRepository;
import br.com.zupacademy.hugo.mercadolivre.repository.ProductRepository;
import br.com.zupacademy.hugo.mercadolivre.validation.UniqueFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(new UniqueFeature());
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid ProductForm productForm, @AuthenticationPrincipal User owner){

        Product product = productForm.convert(categoryRepository, owner);

        productRepository.save(product);

        return ResponseEntity.ok().build();

    }

}
