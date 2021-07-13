package br.com.zupacademy.hugo.mercadolivre.repository;

import br.com.zupacademy.hugo.mercadolivre.enums.StatusPayment;
import br.com.zupacademy.hugo.mercadolivre.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByGatewayIdAndStatus(String gatewayId, StatusPayment statusPayment);
}
