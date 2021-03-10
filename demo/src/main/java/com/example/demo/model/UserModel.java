package com.example.demo.model;

//import lombok.Getter;
//import lombok.Setter;

import javax.persistence.*;

@Entity //annotation
@Table(name = "users")
//@Setter
//@Getter

public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;

    public UserModel() {
        //when use constructor with parameter also using parameterless constructor.
        // Because hibernate internally uses proxys to create proxys object

    }

    public UserModel(String name, String email, String password) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
