package com.example.appp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "discounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DiscountID")
    private Integer discountID;

    @ManyToOne
    @JoinColumn(name = "PromotionID", nullable = true)
    private Promotion promotion;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "ProductID", nullable = true)
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Discount discount = (Discount) o;

        return discountID != null && discountID.equals(discount.discountID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountID);
    }
}

