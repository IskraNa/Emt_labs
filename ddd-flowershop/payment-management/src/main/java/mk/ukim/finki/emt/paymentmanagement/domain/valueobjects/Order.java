package mk.ukim.finki.emt.paymentmanagement.domain.valueobjects;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.paymentmanagement.domain.valueobjects.OrderItemId;
import mk.ukim.finki.emt.paymentmanagement.domain.valueobjects.Product;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
public class Order implements ValueObject {

    private OrderId id;
    private Set<OrderItem> orderItems = new HashSet<>();

    public Money total() {
        return orderItems.stream().map(OrderItem::subtotal).reduce(new Money(Currency.MKD, 0), Money::add);
    }

    public OrderItem addItem(@NonNull Product product, int qty) {
        Objects.requireNonNull(product,"product must not be null");
        var item  = new OrderItem(product.getId(), product.getDescription(), product.getPrice(),qty);
        orderItems.add(item);
        return item;
    }

    public void removeItem(@NonNull OrderItemId orderItemId) {
        Objects.requireNonNull(orderItemId,"Order Item must not be null");
        orderItems.removeIf(v->v.getProductId().equals(orderItemId));
    }
}
