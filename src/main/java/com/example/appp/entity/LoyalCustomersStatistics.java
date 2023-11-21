package com.example.appp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "loyalcustomersstatistics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoyalCustomersStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LoyalCustomersStatisticsID")
    private Integer loyalCustomersStatisticsID;

    @Column(name = "StatDate", nullable = false)
    private Date statDate;

    @Column(name = "TotalLoyalCustomers", nullable = false)
    private int totalLoyalCustomers;

    @Column(name = "ActiveLoyalCustomers", nullable = false)
    private int activeLoyalCustomers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LoyalCustomersStatistics that = (LoyalCustomersStatistics) o;

        return loyalCustomersStatisticsID != null && loyalCustomersStatisticsID.equals(that.loyalCustomersStatisticsID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loyalCustomersStatisticsID);
    }
}

