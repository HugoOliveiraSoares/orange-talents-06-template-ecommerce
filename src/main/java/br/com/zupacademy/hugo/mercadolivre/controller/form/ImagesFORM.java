package br.com.zupacademy.hugo.mercadolivre.controller.form;

import br.com.zupacademy.hugo.mercadolivre.model.Images;
import br.com.zupacademy.hugo.mercadolivre.model.Product;
import br.com.zupacademy.hugo.mercadolivre.model.User;
import br.com.zupacademy.hugo.mercadolivre.repository.ProductRepository;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ImagesFORM {

    @NotNull @Size(min = 1)
    private List<MultipartFile> images;

    public List<Images> convert(Product product){

        List<String> linkImages = this.images.stream().map(image -> "images/"+image.getOriginalFilename()).collect(Collectors.toList());
        List<Images> imagesList = new ArrayList<>();
        linkImages.forEach(link -> imagesList.add( new Images(link, product) ));
        return imagesList;
    }

    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }
}
