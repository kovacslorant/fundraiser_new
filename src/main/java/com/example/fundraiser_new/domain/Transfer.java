package com.example.fundraiser_new.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "transfer")
@Data
@NoArgsConstructor
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "transfer_from")
    private Account source;
    @ManyToOne
    @JoinColumn(name = "transfer_to")
    private Account target;
    private Integer amount;
    private LocalDateTime timeStamp;


}
