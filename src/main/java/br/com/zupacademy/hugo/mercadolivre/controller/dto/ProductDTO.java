package br.com.zupacademy.hugo.mercadolivre.controller.dto;

import br.com.zupacademy.hugo.mercadolivre.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductDTO {

    private String name;
    private Integer price;
    private Integer quantity;
    private String description;
    private Set<Features> features;
    private String category;
    private String owner;
    private List<ComentsDTO> coments = new ArrayList<>();
    private float average;
    private int totalNotes;
    private List<QuestionDTO> questions = new ArrayList<>();
    private List<ImageDTO> images = new ArrayList<>();

    public ProductDTO(Product product, List<Coments> coments, List<Question> questions, List<Images> images) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        this.description = product.getDescription();
        this.features = product.getFeatures();
        this.category = product.getCategory().getName();
        this.owner = product.getOwner().getEmail();
        this.totalNotes = 0;
        for (Coments coment: coments){
            this.coments.add(new ComentsDTO(coment));
            this.totalNotes++;
            this.average += coment.getNote();
        }
        this.average = this.average / totalNotes;

        questions.forEach(question -> this.questions.add(new QuestionDTO(question)));
        images.forEach(image -> this.images.add(new ImageDTO(image)));

    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public Set<Features> getFeatures() {
        return features;
    }

    public String getCategory() {
        return category;
    }

    public String getOwner() {
        return owner;
    }

    public List<ComentsDTO> getComents() {
        return coments;
    }

    public float getAverage() {
        return average;
    }

    public int getTotalNotes() {
        return totalNotes;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public List<ImageDTO> getImages() {
        return images;
    }
}
