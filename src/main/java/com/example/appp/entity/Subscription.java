package com.example.appp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SubscriptionID")
    private Integer subscriptionID;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = true)
    private User user;

    @Column(name = "SubscriptionType", nullable = false)
    private String subscriptionType;

    @Column(name = "Status", nullable = false)
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Subscription that = (Subscription) o;

        return subscriptionID != null && subscriptionID.equals(that.subscriptionID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriptionID);
    }
}

