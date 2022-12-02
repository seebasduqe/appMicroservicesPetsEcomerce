package com.products.userService.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_customer")
    private String name;

    @Column(name = "celNo_customer")
    private String celNo;

    @Column(name = "address_customer")
    private String address;

    @Column(name = "email_customer")
    private String email;

    @Column(name = "username_customer")
    private String username;

    @Column(name = "password_customer")
    private String password;

}
