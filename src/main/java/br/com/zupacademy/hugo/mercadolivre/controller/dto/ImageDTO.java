package br.com.zupacademy.hugo.mercadolivre.controller.dto;

import br.com.zupacademy.hugo.mercadolivre.model.Images;

public class ImageDTO {

    private String linkImage;

    public ImageDTO(Images images) {
        this.linkImage = images.getLinkImage();
    }

    public String getLinkImage() {
        return linkImage;
    }
}
