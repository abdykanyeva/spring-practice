package com.cydeo.entity;


import com.cydeo.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "account_details")
public class Account extends BaseEntity{

    private String address;
    private Integer age;
    private String city;
    private String country;
    private String name;
    private String postalCode;

    private String state;

    @Enumerated(EnumType.STRING)
    private UserRole role;
    @OneToOne(mappedBy = "account")
    private User user;
}
