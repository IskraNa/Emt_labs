package mk.ukim.finki.emt.paymentmanagement.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.paymentmanagement.domain.exceptions.PaymentIdNotExistException;
import mk.ukim.finki.emt.paymentmanagement.domain.models.Payment;
import mk.ukim.finki.emt.paymentmanagement.domain.models.PaymentId;
import mk.ukim.finki.emt.paymentmanagement.domain.repository.PaymentRepository;
import mk.ukim.finki.emt.paymentmanagement.domain.valueobjects.OrderItem;
import mk.ukim.finki.emt.paymentmanagement.service.PaymentService;
import mk.ukim.finki.emt.paymentmanagement.service.forms.OrderItemForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public List<Payment> listAll() {
        return this.paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> findById(PaymentId id) {
        return this.paymentRepository.findById(id);
    }

    @Override
    public void addOrderItem(PaymentId paymentId, OrderItemForm orderItemForm) throws PaymentIdNotExistException {
        Set<OrderItem> orderItems = paymentRepository.findById(paymentId).get().getOrderItemList();
        OrderItem orderItem = new OrderItem(orderItemForm.getProduct().getId(),
                orderItemForm.getProduct().getDescription(),
                orderItemForm.getProduct().getPrice(), orderItemForm.getQuantity());
        orderItems.add(orderItem);
    }

    @Override
    public void removeOrderItem(PaymentId paymentId, OrderItemForm orderItemForm) {
        Set<OrderItem> orderItems = paymentRepository.findById(paymentId).get().getOrderItemList();
        OrderItem orderItem = new OrderItem(orderItemForm.getProduct().getId(),
                orderItemForm.getProduct().getDescription(),
                orderItemForm.getProduct().getPrice(), orderItemForm.getQuantity());
        orderItems.remove(orderItem);
    }
}
