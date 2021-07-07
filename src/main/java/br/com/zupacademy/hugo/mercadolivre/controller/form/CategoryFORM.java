package br.com.zupacademy.hugo.mercadolivre.controller.form;

import br.com.zupacademy.hugo.mercadolivre.model.Category;
import br.com.zupacademy.hugo.mercadolivre.repository.CategoryRepository;
import br.com.zupacademy.hugo.mercadolivre.validation.Unique;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class CategoryFORM {

    @NotNull
    @NotEmpty @Unique(domainClass = Category.class, fieldName = "name", message = "Categoria já cadastrada")
    private String name;
    private String parentCategory;

    public Category convert(CategoryRepository categoryRepository){

        Category category = categoryRepository.findByName(this.parentCategory);

        return new Category(this.name, category);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(String parentCategory) {
        this.parentCategory = parentCategory;
    }
}
