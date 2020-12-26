package com.shevchenko.Model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Hospital> hospitals;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    public City(){
    }

    public City(String name) {
        this.name = name;
        hospitals = new ArrayList<>();
    }

    public void addHospital(Hospital hospital) {
        hospital.setCity(this);
        hospitals.add(hospital);
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return "models.City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country.getName() + '\'' +
                '}';
    }

}