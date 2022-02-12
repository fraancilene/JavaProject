package com.jv.fcsilva.projectcrud.entity.pk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jv.fcsilva.projectcrud.entity.Order;
import com.jv.fcsilva.projectcrud.entity.Product;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

// classe auxiliar
@EqualsAndHashCode
@Embeddable
public class OrderItemPK implements Serializable {
    private static final Long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    
    @JsonIgnore
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
