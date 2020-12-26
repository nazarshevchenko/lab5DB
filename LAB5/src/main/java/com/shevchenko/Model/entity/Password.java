package com.shevchenko.Model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name = "password")
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "pass")
    private String pass;

    @OneToOne(mappedBy = "password", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Patient patient;

    public Password(){
    }

    public Password(String name) {
        this.pass = name;
    }



    public int getId() {
        return id;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }



    @Override
    public String toString() {
        return "models.City{" +
                "id=" + id +
                ", name='" + pass + '\'' +
                '}';
    }

}
