package org.zeetransportations.zeetransportations.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.zeetransportations.zeetransportations.entity.Address;
import org.zeetransportations.zeetransportations.entity.CustomerCustomFields;


@Data
@NoArgsConstructor
public class CustomerResponseDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Address address;
    private String notes;
    private CustomerCustomFields customerCustomFields;

}
