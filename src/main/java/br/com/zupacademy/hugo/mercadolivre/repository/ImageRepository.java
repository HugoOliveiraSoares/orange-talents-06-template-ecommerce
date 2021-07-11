package br.com.zupacademy.hugo.mercadolivre.repository;

import br.com.zupacademy.hugo.mercadolivre.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Images, Long> {
}
