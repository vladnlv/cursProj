package com.example.appp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "promotions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PromotionID")
    private Integer promotionID;

    @Column(name = "PromotionName", nullable = false)
    private String promotionName;

    @Column(name = "PromotionType", nullable = false)
    private String promotionType;

    @Column(name = "Discount", nullable = false)
    private BigDecimal discount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Promotion promotion = (Promotion) o;

        return promotionID != null && promotionID.equals(promotion.promotionID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(promotionID);
    }
}

