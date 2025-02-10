package org.zeetransportations.zeetransportations.entity;

import jakarta.persistence.*;
import lombok.Data;
@Table(name="CustomerTable")
@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    private String notes;

    @Embedded
    private CustomerCustomFields customerCustomFields;


}
