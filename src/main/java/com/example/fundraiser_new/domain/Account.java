package com.example.fundraiser_new.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String ipAddress;
    private String goal;
    private Integer balance;
    private Integer fund;
    @OneToMany(mappedBy = "target")
    private List<Transfer> incomingTransfers = new ArrayList<>();
    @OneToMany(mappedBy = "source")
    private List<Transfer> outgoingTransfers = new ArrayList<>();

}
