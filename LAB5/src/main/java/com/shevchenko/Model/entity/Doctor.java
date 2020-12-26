package com.shevchenko.Model.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "degree_id")
    private Degree degree;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Treatment> treatments;

    public Doctor(){
    }

    public Doctor(String name, String email) {
        this.name = name;
        this.email = email;
        treatments = new ArrayList<>();
    }

    public void addTreatment(Treatment treatment) {
        treatment.setDoctor(this);
        treatments.add(treatment);
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

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setHospital(Hospital hospital){
        this.hospital = hospital;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setDegree(Degree degree){
        this.degree = degree;
    }

    public Degree getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        return "models.Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", Hospital='" + hospital.getName() + '\'' +
                ", Degree='" + degree.getName() + '\'' +
                '}';
    }

}
