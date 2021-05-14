package com.admindashboardactuator.server.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees",schema = "public")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String code;

    @Column(name = "idNumber")
    private String idNumber;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "country")
    private String country;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "creditCardNumber")
    private String creditCardNumber;

    @Column(name = "creditCardType")
    private String creditCardType;

    @Column(name = "creditCardExpiry")
    private String creditCardExpiry;

    @Column(name = "promotionCode")
    private String promotionCode;

    @Column(name = "profession")
    private String profession;

    @Column(name = "skills")
    private String skills;

    @Column(name = "jobTitle")
    private String jobTitle;

    @Column(name = "phone")
    private String phone;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "description")
    private String description;
}
