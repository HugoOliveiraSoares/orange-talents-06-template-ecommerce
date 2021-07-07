package br.com.zupacademy.hugo.mercadolivre.controller.dto;

import br.com.zupacademy.hugo.mercadolivre.model.Category;

public class CategoryDTO {

    private String name;
    private String parentCategory;

    public CategoryDTO(Category category) {
        this.name = category.getName();

        if(category.getParentCategory() == null)
            this.parentCategory = "";
        else
            this.parentCategory = category.getParentCategory().getName();
    }

    public String getName() {
        return name;
    }

    public String getParentCategory() {
        return parentCategory;
    }
}
