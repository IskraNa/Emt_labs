package mk.ukim.finki.emt.paymentmanagement.domain.valueobjects;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.lang.NonNull;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;

@Getter
public class OrderItem implements ValueObject {

    private Money itemPrice;

    @Column(name="qty", nullable = false)
    private int quantity;

    @AttributeOverride(name="id", column = @Column(name="product_id",
            nullable=false))
    private ProductId productId;

    private OrderItem() {
       this.productId = ProductId.randomId(ProductId.class);
    }

    public OrderItem(@NonNull ProductId productId, String description,
                     @NonNull Money itemPrice, int qty) {
        this.productId = productId;
        this.itemPrice = itemPrice;
        this.quantity = qty;
    }

    public Money subtotal(){
        return itemPrice.multiply(quantity);
    }
}
