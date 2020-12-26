package com.shevchenko.Model.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Hospital> hospitals;

    public Region(){
    }

    public Region(String name){
        this.name = name;
        hospitals = new ArrayList<>();
    }

    public void addHospital(Hospital hospital) {
        hospital.setRegion(this);
        hospitals.add(hospital);
    }

    public void removeHospital(Hospital hospital) {
        hospitals.remove(hospital);
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
        return "models.Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
