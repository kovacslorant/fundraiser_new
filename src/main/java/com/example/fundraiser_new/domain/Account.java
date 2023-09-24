package com.example.fundraiser_new.domain;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String ipAddress;
    private String goal;
    private Integer balance;
    private Integer fund;

}
