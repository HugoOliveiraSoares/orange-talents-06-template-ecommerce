package br.com.zupacademy.hugo.mercadolivre.controller.dto;

import br.com.zupacademy.hugo.mercadolivre.model.Question;

public class QuestionDTO {

    private String title;
    private String question;
    private String questioner;

    public QuestionDTO(Question question) {
        this.title = question.getTitle();
        this.question = question.getQuestion();
        this.questioner = question.getQuestioner().getEmail();
    }

    public String getTitle() {
        return title;
    }

    public String getQuestion() {
        return question;
    }

    public String getQuestioner() {
        return questioner;
    }
}
