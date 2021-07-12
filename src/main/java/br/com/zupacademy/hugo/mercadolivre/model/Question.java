package br.com.zupacademy.hugo.mercadolivre.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotEmpty
    private String title;
    @NotNull @NotEmpty
    private String question;
    @NotNull
    private LocalDateTime instantCriation = LocalDateTime.now();
    @NotNull @ManyToOne
    private User ownerProduct;
    @NotNull @OneToOne
    private Product product;
    @NotNull @ManyToOne
    private User questioner;

    @Deprecated
    public Question() {
    }

    public Question(String title, String question, Product product, User ownerProduct, User questioner) {
        this.title = title;
        this.question = question;
        this.ownerProduct = ownerProduct;
        this.product = product;
        this.questioner = questioner;
    }

    public String getTitle() {
        return title;
    }

    public String getQuestion() {
        return question;
    }

    public User getQuestioner() {
        return questioner;
    }

    public User getOwnerProduct() {
        return ownerProduct;
    }
}
