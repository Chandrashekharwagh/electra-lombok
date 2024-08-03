package com.electra.model;

import java.util.Date;

public class Payment{
    private Long id;
    private Double amount;
    private Date paymentDate;
    private int customerId;
    private int orderId;

    public Payment(Long id, Double amount, Date paymentDate, int customerId, int orderId) {
        this.id = id;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.customerId = customerId;
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", customerId=" + customerId +
                ", orderId=" + orderId +
                '}';
    }
}
