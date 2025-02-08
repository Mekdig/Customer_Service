package org.zeetransportations.zeetransportations.dto;


import lombok.*;
import org.zeetransportations.zeetransportations.entity.Address;
import org.zeetransportations.zeetransportations.entity.CustomerCustomFields;


@Data
public class CustomerRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Address address;
    private String notes;
    private CustomerCustomFields customerCustomFields;

}
