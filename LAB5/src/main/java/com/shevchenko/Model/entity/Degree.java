package com.shevchenko.Model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name = "degree")
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "degree", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Doctor> doctors;


    public Degree(){
    }

    public Degree(String name) {
        this.name = name;
        doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctor.setDegree(this);
        doctors.add(doctor);
    }

    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }

    public int getId() {
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "models.City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
