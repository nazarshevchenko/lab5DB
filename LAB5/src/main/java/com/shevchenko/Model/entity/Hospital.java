package com.shevchenko.Model.entity;


import javax.persistence.*;
import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hospital")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Doctor> doctors;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "City_id")
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    public Hospital(){

    }

    public Hospital(String name) {
        this.name = name;
        doctors = new ArrayList<>();
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public void addDoctor(Doctor doctor) {
        doctor.setHospital(this);
        doctors.add(doctor);
    }

    @Override
    public String toString() {
        return "models.Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city.getName() + '\'' +
                ", region='" + region.getName() + '\'' +
                '}';
    }

}
