package mk.ukim.finki.emt.productcatalog.domain.models;

import javax.persistence.*;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Getter
public class Product extends AbstractEntity<ProductId> {

    private String productName;

    private String description;

    private int sales = 0;

    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="price_amount")),
            @AttributeOverride(name="currency", column = @Column(name="price_currency"))
    })
    private Money price;


    //private String picture;

    private Product(){
        super(ProductId.randomId(ProductId.class));
    }

    public static Product build(String productName, String description, Money price, int sales){
        Product p = new Product();
        p.price = price;
        p.productName = productName;
        p.description = description;
        p.sales = sales;
        return p;
    }

    public void addSales(int qty){
        this.sales = this.sales - qty;

    }

    public void removeSales(int qty){
        this.sales -= qty;
    }
}
