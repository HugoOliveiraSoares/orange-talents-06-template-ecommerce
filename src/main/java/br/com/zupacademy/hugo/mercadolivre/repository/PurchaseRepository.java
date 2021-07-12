package br.com.zupacademy.hugo.mercadolivre.repository;

import br.com.zupacademy.hugo.mercadolivre.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
