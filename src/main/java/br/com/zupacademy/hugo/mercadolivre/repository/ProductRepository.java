package br.com.zupacademy.hugo.mercadolivre.repository;

import br.com.zupacademy.hugo.mercadolivre.model.Product;
import br.com.zupacademy.hugo.mercadolivre.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


    Product findByNameAndOwner(String product, User owner);
}
