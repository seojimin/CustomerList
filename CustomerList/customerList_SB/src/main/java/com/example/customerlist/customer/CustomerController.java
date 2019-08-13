package com.example.customerlist.customer;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    //Read
    @GetMapping("/")
    public ResponseEntity getAllCus(){
        List<Customer> list = customerRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    //Read
    @GetMapping("/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable String id){
        Optional customer = customerRepository.findById(Long.parseLong(id));

        return ResponseEntity.ok().body(customer);
    }

    //Create, Save
    @PostMapping
    public ResponseEntity savePost(@Valid @RequestBody CustomerDTO dto){
        Customer dtoCus = dto.toEntity();
        Customer customer = customerRepository.save(dtoCus);

        return ResponseEntity.ok().body(customer);
    }

    //Update
    @PutMapping("/customers/{id}")
    public ResponseEntity updateCustomer(@PathVariable String id, @RequestBody CustomerDTO dto){
        Optional exist = customerRepository.findById(Long.parseLong(id));

        if(!exist.isPresent()){
            return null;
        }

        Customer customer = (Customer)exist.get();
        customer.setName(dto.getName());
        customer.setPhone(dto.getPhone());
        customer.setEmail(dto.getEmail());
        customer.setAccount_num(dto.getAccount_num());
        customer.setAddress(dto.getAddress());

        Customer updateCus = customerRepository.save(customer);
        return ResponseEntity.ok().body(updateCus);
    }

    //Delete
    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteCustomer(@PathVariable String id){
        customerRepository.deleteById(Long.parseLong(id));
        return ResponseEntity.noContent().build();
    }
}