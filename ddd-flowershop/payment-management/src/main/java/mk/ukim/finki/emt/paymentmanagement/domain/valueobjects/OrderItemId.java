package mk.ukim.finki.emt.paymentmanagement.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;


public class OrderItemId extends DomainObjectId {

    private OrderItemId() {
        super(OrderItemId.randomId(OrderItemId.class).getId());
    }

    public OrderItemId(String uuid) {
        super(uuid);
    }
}
