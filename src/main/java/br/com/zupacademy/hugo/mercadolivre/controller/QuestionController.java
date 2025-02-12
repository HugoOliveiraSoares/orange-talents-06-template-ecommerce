package br.com.zupacademy.hugo.mercadolivre.controller;

import br.com.zupacademy.hugo.mercadolivre.controller.form.QuestionFORM;
import br.com.zupacademy.hugo.mercadolivre.model.Product;
import br.com.zupacademy.hugo.mercadolivre.model.Question;
import br.com.zupacademy.hugo.mercadolivre.model.User;
import br.com.zupacademy.hugo.mercadolivre.repository.ProductRepository;
import br.com.zupacademy.hugo.mercadolivre.repository.QuestionRepository;
import br.com.zupacademy.hugo.mercadolivre.components.Mailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product/{id}/questions")
public class QuestionController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private Mailer mailer;

    @PostMapping
    public ResponseEntity<?> register(@PathVariable Long id, @RequestBody QuestionFORM questionFORM,
                                      @AuthenticationPrincipal User questioner){

        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty())
            return ResponseEntity.notFound().build();

        Question question = questionFORM.convert(product.get(), questioner);

        questionRepository.save(question);

        mailer.send(question.getTitle(), question.getQuestion(), question.getOwnerProduct().getEmail(), question.getQuestioner().getEmail());

        return ResponseEntity.ok().build();

    }

}
