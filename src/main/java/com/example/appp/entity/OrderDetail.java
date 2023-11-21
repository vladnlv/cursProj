package com.example.appp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orderdetails")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderDetailID")
    private Integer orderDetailID;

    @ManyToOne
    @JoinColumn(name = "OrderID", nullable = true)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ProductID", nullable = true)
    private Product product;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderDetail that = (OrderDetail) o;

        return orderDetailID != null && orderDetailID.equals(that.orderDetailID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDetailID);
    }
}

