package org.zeetransportations.zeetransportations.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.time.LocalDate;

@Embeddable
@Data
public class CustomerCustomFields {
    private LocalDate birthday;
    private String company;
}
