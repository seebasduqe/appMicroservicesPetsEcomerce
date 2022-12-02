package com.products.userService.Controller;


import com.products.userService.Entity.Customer;
import com.products.userService.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>>  getCustomersAll(){
        List<Customer> customers = customerService.getAll();
        if(customers.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
        Customer customerById = customerService.getCustomerById(id);
        if(customerById == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customerById);
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        Customer newCustomer = customerService.saveCustomer(customer);
        if(customer == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable("id") Long id){
        Customer updateCustomer = customerService.updateCustomer(customer,id);
        if(customer == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id){
        Customer deleteCustomerById = customerService.getCustomerById(id);
        if(deleteCustomerById == null){
            return ResponseEntity.notFound().build();
        }
        customerService.deleteCustomer(id);
        return ResponseEntity.ok(deleteCustomerById);
    }

}
