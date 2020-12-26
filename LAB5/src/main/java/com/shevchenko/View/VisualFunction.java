package com.shevchenko.View;

import com.shevchenko.Controller.services.*;
import com.shevchenko.Model.entity.*;

import java.util.List;
import java.util.Scanner;

public class VisualFunction {
    public static String getCommand(){
        Scanner console = new Scanner(System.in);

        return console.nextLine();
    }

    public static void printCommands(){
        System.out.println("0 - Exit");
        System.out.println("1 - Select");
        System.out.println("2 - Insert");
        System.out.println("3 - Update");
        System.out.println("4 - Delete");
    }

    public static void writeTables(){

        String[] tables = getTablesName();
        String tableStr;
        for (int i = 0; i < tables.length; i++){
            tableStr = String.format("%s - %s", i + 1, tables[i]);
            System.out.println(tableStr);
        }

    }


    public static String[] getTablesName(){
        String[] tablesName = {"Country", "City", "Hospital", "Region", "Doctor",
                "Degree", "Patient", "Treatment", "Password"};
        return tablesName;
    }

    public static void writePasswords(PasswordService passwordService){
        List<Password> passwords = passwordService.findAllPasswords();
        for (int i = 0; i < passwords.size(); i++){
            System.out.println(passwords.get(i));
        }
    }

    public static void writeTreatments(TreatmentService treatmentService){
        List<Treatment> treatments = treatmentService.findAllTreatments();
        for (int i = 0; i < treatments.size(); i++){
            System.out.println(treatments.get(i));
        }
    }

    public static void writePatients(PatientService patientService){
        List<Patient> patients = patientService.findAllPatients();
        for (int i = 0; i < patients.size(); i++){
            System.out.println(patients.get(i));
        }
    }

    public static void writeCountries(CountryService countryService){
        List<Country> countries = countryService.findAllCountrys();
        for (int i = 0; i < countries.size(); i++){
            System.out.println(countries.get(i));
        }
    }

    public static void writeCities(CityService cityService){
        List<City> cities = cityService.findAllCities();
        for (int i = 0; i < cities.size(); i++){
            System.out.println(cities.get(i));
        }
    }

    public static void writeHospitals(HospitalService hospitalService){
        List<Hospital> hospitals = hospitalService.findAllHospitals();
        for (int i = 0; i < hospitals.size(); i++){
            System.out.println(hospitals.get(i));
        }
    }

    public static void writeRegions(RegionService regionService){
        List<Region> regions = regionService.findAllRegions();
        for (int i = 0; i < regions.size(); i++){
            System.out.println(regions.get(i));
        }
    }

    public static void writeDoctors(DoctorService doctorService){
        List<Doctor> doctors = doctorService.findAllDoctors();
        for (int i = 0; i < doctors.size(); i++){
            System.out.println(doctors.get(i));
        }
    }

    public static void writeDegrees(DegreeService degreeService){
        List<Degree> degrees = degreeService.findAllDegree();
        for (int i = 0; i < degrees.size(); i++){
            System.out.println(degrees.get(i));
        }
    }

}
