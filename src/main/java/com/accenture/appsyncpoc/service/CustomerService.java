package com.accenture.appsyncpoc.service;

import java.util.List;
import com.accenture.appsyncpoc.entity.Customer;
import com.accenture.appsyncpoc.error.CustomerNotFoundException;
import com.accenture.appsyncpoc.error.CustomerWithEmailAlreadyExists;

public interface CustomerService {

  Customer saveCustomer(Customer customer) throws CustomerWithEmailAlreadyExists;

  List<Customer> getAllCustomers();

  Customer getCustomerByEmail(String email) throws CustomerNotFoundException;

  void deleteCustomerByID(Long id);


}
