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
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "LastName")
    private String LastName;
    @Column(name = "email")
    private String email;
    @Column(name = "jobTitle")
    private String jobTitle;
    @Column(name = "phone")
    private String phone;
    @Column(name = "imageUrl")
    private String imageUrl;
}
