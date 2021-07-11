package br.com.zupacademy.hugo.mercadolivre.repository;

import br.com.zupacademy.hugo.mercadolivre.model.Coments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentsRepository extends JpaRepository<Coments, Long> {
}
