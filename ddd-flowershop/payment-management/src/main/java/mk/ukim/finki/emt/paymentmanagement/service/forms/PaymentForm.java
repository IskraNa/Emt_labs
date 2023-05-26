package mk.ukim.finki.emt.paymentmanagement.service.forms;

import mk.ukim.finki.emt.paymentmanagement.domain.models.PaymentMethod;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.validation.constraints.NotNull;


public class PaymentForm {

    private Money total;

    @NotNull
    private String transaction;

    private PaymentMethod paymentMethod;

}
