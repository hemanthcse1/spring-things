package com.hemanth.springthings.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "actor")
public class Actor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
}
