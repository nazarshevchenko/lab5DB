package com.shevchenko.Model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Treatment> treatments;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "password_id")
    private Password password;

    public Patient(){
    }

    public Patient(String name) {
        this.name = name;
        treatments = new ArrayList<>();
        password = new Password();
    }

    public int getId() {
        return id;
    }

    public void addTreatment(Treatment treatment) {
        treatment.setPatient(this);
        treatments.add(treatment);
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public Password getPassword() {
        return password;
    }


    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return "models.Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passId='" + password.getId() + '\'' +
                '}';
    }
}
