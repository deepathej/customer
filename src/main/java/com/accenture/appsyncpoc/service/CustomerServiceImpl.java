package com.accenture.appsyncpoc.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.accenture.appsyncpoc.entity.Customer;
import com.accenture.appsyncpoc.error.CustomerNotFoundException;
import com.accenture.appsyncpoc.error.CustomerWithEmailAlreadyExists;
import com.accenture.appsyncpoc.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  private final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

  @Override
  public Customer saveCustomer(Customer customer) throws CustomerWithEmailAlreadyExists {
    try {
      LOGGER.info("Customer added to DB");
      return customerRepository.save(customer);
    } catch (Exception e) {
      LOGGER.info("Customer not added to DB - Cutomer with email/ID already Exists");
      throw new CustomerWithEmailAlreadyExists("Cutomer with email/id already Exists");
    }
  }

  @Override
  public List<Customer> getAllCustomers() {
    LOGGER.info("Getting all the customers");
    return customerRepository.findAll();
  }

  @Override
  public Customer getCustomerByEmail(String email) throws CustomerNotFoundException {
    Optional<Customer> customer = customerRepository.findByEmail(email);
    if (customer.isPresent()) {
      LOGGER.info("Customer with specified email is returned");
      return customer.get();
    } else {
      LOGGER.info("Customer with specified email not found");
      throw new CustomerNotFoundException("Customer with specified email not found");
    }
  }

  @Override
  public String deleteCustomerByID(Long id) {
    try {
      customerRepository.deleteById(id);
      LOGGER.info("Customer deleted");
    } catch (EmptyResultDataAccessException e) {
      LOGGER.info("Customer with Id not found");
      return "No Customer with id: " + id;
    }
    return "Customer with id: " + id + " deleted";
  }

}
