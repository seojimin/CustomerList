package com.example.customerlist.customer;

import lombok.*;
import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "account_num")
    private String account_num;
    @Column(name = "address")
    private String address;

    @Builder
    public Customer(String name, String phone, String email, String account_num, String address){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.account_num = account_num;
        this.address = address;
    }
}
