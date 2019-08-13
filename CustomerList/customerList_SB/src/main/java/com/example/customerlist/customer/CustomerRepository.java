package com.example.customerlist.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> { // <Entity class, PK type>

}
