package com.springboot.customer.modal;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@ToString

@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    private String mail;
    private String number;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String city;
    private String zipCode;
    private String country;

    public Customer(String name, String gender, String mail, String number, String addressLine1, String addressLine2, String state, String city, String zipCode, String country) {
        this.name = name;
        this.gender = gender;
        this.mail = mail;
        this.number = number;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }
}
