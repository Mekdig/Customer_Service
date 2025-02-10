package org.zeetransportations.zeetransportations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zeetransportations.zeetransportations.dto.CustomerRequestDTO;
import org.zeetransportations.zeetransportations.dto.CustomerResponseDTO;
import org.zeetransportations.zeetransportations.service.CustomerService;

@RestController()
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/get/{customerId}")
    public ResponseEntity<?> getCustomerInfo(@PathVariable(name = "customerId") int id){
        CustomerResponseDTO customer = customerService.getCustomerInfoById(id);
        if(customer==null){
            return new ResponseEntity<>("no data found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createCustomerInfo(@RequestBody CustomerRequestDTO customerRequestDTO){
        CustomerResponseDTO cust= customerService.postCustomerInfo(customerRequestDTO);

        return new ResponseEntity<>(cust, HttpStatus.OK);
    }
    @PutMapping("/update/{customerId}")
    public ResponseEntity<?> updateCustomerInfo(@PathVariable int customerId, @RequestBody CustomerRequestDTO customerRequestDTO){

        CustomerResponseDTO cust = customerService.updatedCustomerInfo(customerRequestDTO,customerId);

        return new ResponseEntity<>(cust, HttpStatus.OK);
    }


}
