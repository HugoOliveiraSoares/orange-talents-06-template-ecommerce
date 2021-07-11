package br.com.zupacademy.hugo.mercadolivre.controller.form;

import br.com.zupacademy.hugo.mercadolivre.model.Images;
import br.com.zupacademy.hugo.mercadolivre.model.Product;
import br.com.zupacademy.hugo.mercadolivre.model.User;
import br.com.zupacademy.hugo.mercadolivre.repository.ProductRepository;
import org.springframework.util.Assert;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ImagesFORM {

    @NotNull @Size(min = 1)
    private String linkImage;

    public Images convert(Product product){
        return new Images(this.linkImage, product);
    }


    public String getLinkImage() {
        return linkImage;
    }
}
