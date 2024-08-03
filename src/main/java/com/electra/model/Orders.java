package com.electra.model;

import java.util.Date;

public class Orders {
    private Long id;
    private int productId;
    private int customerId;
    private Date orderDate;

    public Orders(Long id, int productId, int customerId, Date orderDate) {
        this.id = id;
        this.productId = productId;
        this.customerId = customerId;
        this.orderDate = orderDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", productId=" + productId +
                ", customerId=" + customerId +
                ", orderDate=" + orderDate +
                '}';
    }
}
