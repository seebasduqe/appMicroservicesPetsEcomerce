package com.products.userService.Service;

import com.products.userService.Entity.Customer;
import com.products.userService.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAll();
    public Customer getCustomerById(Long id);
    public Customer saveCustomer(Customer customer);

    public Customer updateCustomer(Customer customer, Long id);
    public void deleteCustomer(Long id);

}
