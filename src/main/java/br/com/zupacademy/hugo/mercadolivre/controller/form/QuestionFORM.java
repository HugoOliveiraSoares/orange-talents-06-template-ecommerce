package br.com.zupacademy.hugo.mercadolivre.controller.form;

import br.com.zupacademy.hugo.mercadolivre.model.Product;
import br.com.zupacademy.hugo.mercadolivre.model.Question;
import br.com.zupacademy.hugo.mercadolivre.model.User;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class QuestionFORM {

    @NotNull @NotEmpty
    private String title;
    @NotNull @NotEmpty
    private String question;

    public QuestionFORM(String title, String question) {
        this.title = title;
        this.question = question;
    }

    public String getTitle() {
        return title;
    }

    public String getQuestion() {
        return question;
    }

    public Question convert(Product product, User questioner) {
        return new Question(this.title, this.question, product, product.getOwner(), questioner);
    }
}
