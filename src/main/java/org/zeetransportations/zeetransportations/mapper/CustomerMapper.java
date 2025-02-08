package org.zeetransportations.zeetransportations.mapper;

import org.zeetransportations.zeetransportations.dto.CustomerRequestDTO;
import org.zeetransportations.zeetransportations.dto.CustomerResponseDTO;
import org.zeetransportations.zeetransportations.entity.Customer;

public class CustomerMapper {


    public static CustomerResponseDTO customerToCustomerResponseDTO(Customer customer) {
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        customerResponseDTO.setId(customer.getId());
        customerResponseDTO.setFirstName(customer.getFirstName());
        customerResponseDTO.setLastName(customer.getLastName());
        customerResponseDTO.setEmail(customer.getEmail());
        customerResponseDTO.setPhone(customer.getPhone());
        customerResponseDTO.setAddress(customer.getAddress());
        customerResponseDTO.setCustomerCustomFields(customer.getCustomerCustomFields());
        customerResponseDTO.setNotes(customer.getNotes());

        return customerResponseDTO;
    }

    public static Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO){
        Customer customer = new Customer();
        customer.setFirstName(customerRequestDTO.getFirstName());
        customer.setLastName(customerRequestDTO.getLastName());
        customer.setEmail(customerRequestDTO.getEmail());
        customer.setPhone(customerRequestDTO.getPhone());
        customer.setAddress(customerRequestDTO.getAddress());
        customer.setCustomerCustomFields(customerRequestDTO.getCustomerCustomFields());
        customer.setNotes(customerRequestDTO.getNotes());

        return customer;

    }
}
