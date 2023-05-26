package mk.ukim.finki.emt.paymentmanagement.domain.models;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class PaymentId extends DomainObjectId {

    protected PaymentId(@NonNull String uuid) {
        super(uuid);
    }
}
