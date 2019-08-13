package com.example.customerlist.customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO {
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

    public Customer toEntity(){
        return Customer.builder()
                .name(name)
                .phone(phone)
                .email(email)
                .account_num(account_num)
                .address(address)
                .build();
    }
}
