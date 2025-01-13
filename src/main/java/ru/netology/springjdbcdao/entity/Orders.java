package ru.netology.springjdbcdao.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customers;

    @Column(name = "product_name", length = 128)
    private String productName;

    @Column(name = "amount", nullable = false)
    private int amount;
}