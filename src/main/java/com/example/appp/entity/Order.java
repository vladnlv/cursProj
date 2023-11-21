package com.example.appp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private Integer orderID;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = true)
    private User user;

    @Column(name = "OrderStatus", nullable = false)
    private String orderStatus;

    @Column(name = "TotalAmount", nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "OrderDate", nullable = false)
    private LocalDateTime orderDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Order order = (Order) o;

        return orderID != null && orderID.equals(order.orderID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID);
    }
}

