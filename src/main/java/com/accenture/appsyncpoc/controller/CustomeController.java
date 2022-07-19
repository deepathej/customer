package com.accenture.appsyncpoc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.accenture.appsyncpoc.entity.Customer;
import com.accenture.appsyncpoc.error.CustomerNotFoundException;
import com.accenture.appsyncpoc.error.CustomerWithEmailAlreadyExists;
import com.accenture.appsyncpoc.service.CustomerService;


@RestController
@RequestMapping("/api/customer")
public class CustomeController {

  @Autowired
  private CustomerService customerService;

  @PostMapping("/")
  public Customer saveCustomer(@RequestBody Customer customer)
      throws CustomerWithEmailAlreadyExists {
    return customerService.saveCustomer(customer);
  }

  @GetMapping("/all")
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }

  @GetMapping("/{email}")
  public Customer getCustomerByEmail(@PathVariable("email") String email)
      throws CustomerNotFoundException {
    return customerService.getCustomerByEmail(email);
  }

  @DeleteMapping("/{id}")
  public String deleteCustomerByID(@PathVariable("id") Long id) {
    customerService.deleteCustomerByID(id);
    return "Successfully deleted";
  }

}
