package mk.ukim.finki.emt.paymentmanagement.domain.models;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.paymentmanagement.domain.valueobjects.OrderItem;
import mk.ukim.finki.emt.paymentmanagement.domain.valueobjects.OrderItemId;
import mk.ukim.finki.emt.paymentmanagement.domain.valueobjects.Product;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "payments")
@Getter
public class Payment extends AbstractEntity<PaymentId> {

    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="payment_amount")),
            @AttributeOverride(name="currency", column = @Column(name="payment_currency"))
    })
    private Money total;

    private String transaction;

    @Enumerated(value = EnumType.STRING)
    private PaymentMethod paymentMethod;


    @ElementCollection
    private Set<OrderItem> orderItemList = new HashSet<>();


    public Money totalSum() {
        return orderItemList.stream().map(OrderItem::subtotal).reduce(new Money(total.getCurrency(), 0), Money::add);
    }

    public OrderItem addItem(@NonNull Product product, int qty) {
        Objects.requireNonNull(product,"product must not be null");
        var item  = new OrderItem(product.getId(), product.getDescription(), product.getPrice(),qty);
        orderItemList.add(item);
        return item;
    }

    public void removeItem(@NonNull OrderItemId orderItemId) {
        Objects.requireNonNull(orderItemId,"Order Item must not be null");
        orderItemList.removeIf(v->v.getProductId().equals(orderItemId));
    }
}
