package com.example.appp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "loyaltyprogram")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoyaltyProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LoyaltyProgramID")
    private Integer loyaltyProgramID;

    @Column(name = "LoyaltyProgramName", nullable = false)
    private String loyaltyProgramName;

    @Column(name = "LoyaltyProgramConditions", nullable = false, columnDefinition = "TEXT")
    private String loyaltyProgramConditions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LoyaltyProgram that = (LoyaltyProgram) o;

        return loyaltyProgramID != null && loyaltyProgramID.equals(that.loyaltyProgramID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loyaltyProgramID);
    }
}

