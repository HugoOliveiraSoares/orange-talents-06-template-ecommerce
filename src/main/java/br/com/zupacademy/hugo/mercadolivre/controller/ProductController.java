package br.com.zupacademy.hugo.mercadolivre.controller;

import br.com.zupacademy.hugo.mercadolivre.controller.dto.ProductDTO;
import br.com.zupacademy.hugo.mercadolivre.controller.form.ProductForm;
import br.com.zupacademy.hugo.mercadolivre.model.*;
import br.com.zupacademy.hugo.mercadolivre.repository.*;
import br.com.zupacademy.hugo.mercadolivre.validation.UniqueFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ComentsRepository comentsRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ImageRepository imageRepository;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(new UniqueFeature());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> details(@PathVariable Long id){

        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty())
            return ResponseEntity.notFound().build();

        List<Coments> coments = comentsRepository.findByProduct(product.get());
        List<Question> questions = questionRepository.findByProduct(product.get());
        List<Images> images = imageRepository.findByProduct(product.get());

        ProductDTO productDTO = new ProductDTO(product.get(), coments, questions, images);

        return ResponseEntity.ok().body(productDTO);

    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid ProductForm productForm, @AuthenticationPrincipal User owner){

        Product product = productForm.convert(categoryRepository, owner);

        productRepository.save(product);

        return ResponseEntity.ok().build();

    }

}
