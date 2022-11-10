package com.cydeo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_account")
public class User extends BaseEntity{

    private String email;
    private String password;
    private String username;

    @JoinColumn(name = "account_details_id")
    @OneToOne(fetch=FetchType.LAZY)
    private Account account;


}
