package mk.ukim.finki.emt.paymentmanagement.service;

import mk.ukim.finki.emt.paymentmanagement.domain.models.Payment;
import mk.ukim.finki.emt.paymentmanagement.domain.models.PaymentId;
import mk.ukim.finki.emt.paymentmanagement.service.forms.OrderItemForm;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    List<Payment> listAll();
    Optional<Payment> findById(PaymentId id);
    void addOrderItem(PaymentId paymentId , OrderItemForm orderItemForm);
    void removeOrderItem(PaymentId paymentId, OrderItemForm orderItemForm);
}
