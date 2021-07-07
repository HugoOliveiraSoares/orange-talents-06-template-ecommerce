package br.com.zupacademy.hugo.mercadolivre.controller;

import br.com.zupacademy.hugo.mercadolivre.controller.dto.CategoryDTO;
import br.com.zupacademy.hugo.mercadolivre.controller.form.CategoryFORM;
import br.com.zupacademy.hugo.mercadolivre.model.Category;
import br.com.zupacademy.hugo.mercadolivre.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> list(){

        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();

        for (Category category: categories) {
            categoryDTOS.add(new CategoryDTO(category));
        }

        return ResponseEntity.ok().body(categoryDTOS) ;

    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid CategoryFORM categoryFORM){

        Category category = categoryFORM.convert(categoryRepository);

        categoryRepository.save(category);

        return ResponseEntity.ok().build();
    }

}
