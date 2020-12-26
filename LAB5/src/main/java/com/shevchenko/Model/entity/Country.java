package com.shevchenko.Model.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<City> citys;


    public Country(){
    }

    public Country(String name) {
        this.name = name;
        citys = new ArrayList<>();
    }

    public void addCity(City city) {
        city.setCountry(this);
        citys.add(city);
    }

    public void removeCity(City city) {
        citys.remove(city);
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
