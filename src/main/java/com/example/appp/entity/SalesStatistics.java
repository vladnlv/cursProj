package com.example.appp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "salesstatistics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SalesStatisticsID")
    private Integer salesStatisticsID;

    @Column(name = "SaleDate", nullable = false)
    private Date saleDate;

    @Column(name = "SoldItems", nullable = false)
    private int soldItems;

    @Column(name = "TotalAmount", nullable = false)
    private BigDecimal totalAmount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SalesStatistics that = (SalesStatistics) o;

        return salesStatisticsID != null && salesStatisticsID.equals(that.salesStatisticsID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salesStatisticsID);
    }
}

