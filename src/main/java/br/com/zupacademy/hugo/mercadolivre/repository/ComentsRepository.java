package br.com.zupacademy.hugo.mercadolivre.repository;

import br.com.zupacademy.hugo.mercadolivre.model.Coments;
import br.com.zupacademy.hugo.mercadolivre.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComentsRepository extends JpaRepository<Coments, Long> {
    List<Coments> findByProduct(Product product);
}
