package com.springapi.friendcrudapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Friend")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstname;
    private String lastname;
    private String department;
    private String email;
    private String country;

    public Friend(String firstname, String lastname, String department, String email, String country) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        this.email = email;
        this.country = country;
    }
}
