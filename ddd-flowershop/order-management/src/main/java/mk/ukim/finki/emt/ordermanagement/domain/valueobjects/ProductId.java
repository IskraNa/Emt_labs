package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;


public class ProductId extends DomainObjectId {

    private ProductId() {
        super(ProductId.randomId(ProductId.class).getId());
    }

    public ProductId(String uuid) {
        super(uuid);
    }


}
