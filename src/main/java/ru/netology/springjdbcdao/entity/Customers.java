package ru.netology.springjdbcdao.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "surname", length = 100, nullable = false)
    private String surname;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL) // один ко многим
    private List<Orders> orders;

}