package org.zeetransportations.zeetransportations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zeetransportations.zeetransportations.dto.CustomerRequestDTO;
import org.zeetransportations.zeetransportations.dto.CustomerResponseDTO;
import org.zeetransportations.zeetransportations.entity.Customer;
import org.zeetransportations.zeetransportations.mapper.CustomerMapper;
import org.zeetransportations.zeetransportations.repository.CustomerRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Get Customer information
     * @param id
     * @return CustomerResponseDTO
     */
    public CustomerResponseDTO getCustomerInfoById(int id){
        Optional<Customer> OptionalCustomer = customerRepository.findById(id); // Read Customer information from Database
        if(OptionalCustomer.isEmpty()){  // check if customer data exist on Database
            return null;
        }
        Customer cust =OptionalCustomer.get();  // get the actual data from optional wrapper object
        CustomerResponseDTO customerDTO =CustomerMapper.customerToCustomerResponseDTO(cust); // Map Customer to Customer  Response DTO
        return customerDTO;
    }

    /**
     * This method used to create new Customer info
     * @param customerRequestDTO
     * @return CustomerResponseDTO
     */
    public CustomerResponseDTO postCustomerInfo(CustomerRequestDTO customerRequestDTO){

        Customer customer1 = CustomerMapper.customerRequestDTOToCustomer(customerRequestDTO) ; // Map Customer Request DTO to Customer
        Customer cust = customerRepository.save(customer1); // save customer information to Database
        CustomerResponseDTO customerDTO1 = CustomerMapper.customerToCustomerResponseDTO(cust); // Map Customer to Customer  Response DTO
        return customerDTO1;
    }

    /**
     * update existing customer information
     *
     * @param customerRequestDTO
     * @param customerId
     * @return CustomerResponseDTO
     */
    public CustomerResponseDTO updatedCustomerInfo(CustomerRequestDTO customerRequestDTO, Integer customerId){
        Optional<Customer> customerOptional = customerRepository.findById(customerId);  // read the existing data
        if(customerOptional.isEmpty()){ // check if the customer data exist
            throw new NoSuchElementException();
        }
        Customer customer = customerOptional.get();   // get the actual data from optional wrapper object
        customer.setCustomerCustomFields(customerRequestDTO.getCustomerCustomFields());
        customer.setEmail(customerRequestDTO.getEmail());
        customer.setNotes(customerRequestDTO.getNotes());
        customer.setAddress(customerRequestDTO.getAddress());
        customer.setPhone(customerRequestDTO.getPhone());
        customer.setFirstName(customerRequestDTO.getFirstName());
        customer.setLastName(customerRequestDTO.getLastName());

        Customer cust = customerRepository.save(customer); // save customer information to Database
        CustomerResponseDTO customerUpdatedResponseDTO = CustomerMapper.customerToCustomerResponseDTO(cust);
        return customerUpdatedResponseDTO;



    }
}
