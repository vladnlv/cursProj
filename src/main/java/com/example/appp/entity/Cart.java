package com.example.appp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cart")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartID")
    private Integer cartID;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "ProductID", nullable = true)
    private Product product;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cart cart = (Cart) o;

        return cartID != null && cartID.equals(cart.cartID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartID);
    }
}

