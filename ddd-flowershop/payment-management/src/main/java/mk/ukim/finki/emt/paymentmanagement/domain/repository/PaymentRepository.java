package mk.ukim.finki.emt.paymentmanagement.domain.repository;

import mk.ukim.finki.emt.paymentmanagement.domain.models.Payment;
import mk.ukim.finki.emt.paymentmanagement.domain.models.PaymentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, PaymentId> {

}
