package com.shevchenko.View;

import com.shevchenko.Controller.services.*;
import com.shevchenko.Model.entity.*;

import java.sql.SQLException;
import java.util.List;

import static com.shevchenko.View.VisualFunction.*;

public class main {

    private static Integer tableId;
    private static Integer rowId;
    private static String name;
    public static void main(String[] args) throws SQLException{

        CountryService countryService = new CountryService();
        CityService cityService = new CityService();
        HospitalService hospitalService = new HospitalService();
        RegionService regionService = new RegionService();
        DoctorService doctorService = new DoctorService();
        DegreeService degreeService = new DegreeService();
        PatientService patientService = new PatientService();
        TreatmentService treatmentService = new TreatmentService();
        PasswordService passwordService = new PasswordService();

        while (true){
            printCommands();
            String command = getCommand();

            if(command.equals("0")){ break; }

            else if(command.equals("1")){
                while (true){
                    System.out.println("0 - Exit");
                    writeTables();

                    try {
                        tableId = Integer.parseInt(getCommand());
                        if ((tableId < 0) || (tableId > getTablesName().length)) {
                            System.out.println("It's not tableId");
                        }
                        else if (tableId == 0) {
                            System.out.println("Exit");
                            break;
                        }
                        else {
                            if(tableId == 1){
                                writeCountries(countryService);
                            }
                            else if(tableId == 2){
                                writeCities(cityService);
                            }
                            else if(tableId == 3){
                                writeHospitals(hospitalService);
                            }
                            else if(tableId == 4){
                                writeRegions(regionService);
                            }
                            else if(tableId == 5){
                                writeDoctors(doctorService);
                            }
                            else if(tableId == 6){
                                writeDegrees(degreeService);
                            }
                            else if(tableId == 7){
                                writePatients(patientService);
                            }
                            else if(tableId == 8){
                                writeTreatments(treatmentService);
                            }
                            else if(tableId == 9){
                                writePasswords(passwordService);
                            }

                        }


                    } catch (Exception e) {
                        System.out.println("It's not tableId");
                    }
                }
            }

            else if(command.equals("2")){
                while (true){
                    System.out.println("0 - Exit");
                    writeTables();
                    try {
                        tableId = Integer.parseInt(getCommand());
                        if ((tableId < 0) || (tableId > getTablesName().length)) {
                            System.out.println("It's not tableId");
                        }
                        else if (tableId == 0) {
                            System.out.println("Exit");
                            break;
                        }
                        else {
                            if(tableId == 1){
                                System.out.println("Set name");
                                name = getCommand();
                                Country country = new Country(name);
                                countryService.saveCountry(country);
                            }
                            else if(tableId == 2){
                                System.out.println("Set name");
                                name = getCommand();
                                System.out.println("Select country");
                                writeCountries(countryService);
                                rowId = Integer.parseInt(getCommand());
                                try {
                                    Country country = countryService.findCountry(rowId);
                                    City city = new City(name);
                                    city.setCountry(country);
                                    country.addCity(city);
                                    countryService.updateCountry(country);
                                }catch (Exception e) { System.out.println("Error"); }


                            }
                            else if(tableId == 3){
                                System.out.println("Set name");
                                name = getCommand();
                                System.out.println("Select city");
                                writeCities(cityService);
                                rowId = Integer.parseInt(getCommand());
                                try {
                                    City city = cityService.findCity(rowId);
                                    Hospital hospital = new Hospital(name);
                                    hospital.setCity(city);
                                    city.addHospital(hospital);

                                    System.out.println("Select region");
                                    writeRegions(regionService);
                                    rowId = Integer.parseInt(getCommand());
                                    Region region = regionService.findRegion(rowId);
                                    hospital.setRegion(region);
                                    region.addHospital(hospital);
                                    regionService.updateRegion(region);

                                }catch (Exception e) { System.out.println("Error"); }
                            }
                            else if(tableId == 4){
                                try {
                                    System.out.println("Set name");
                                    name = getCommand();
                                    Region region = new Region();
                                    region.setName(name);
                                    regionService.saveRegion(region);
                                } catch (Exception e) { System.out.println("Error"); }
                            }
                            else if(tableId == 5){
                                System.out.println("Set name");
                                name = getCommand();
                                Doctor doctor = new Doctor();
                                doctor.setName(name);

                                System.out.println("Set email");
                                String email = getCommand();
                                doctor.setEmail(email);

                                System.out.println("Select Hospital");
                                writeHospitals(hospitalService);
                                rowId = Integer.parseInt(getCommand());
                                Hospital hospital = hospitalService.findHospital(rowId);
                                doctor.setHospital(hospital);


                                System.out.println("Select Degree");
                                writeDegrees(degreeService);
                                rowId = Integer.parseInt(getCommand());
                                Degree degree = degreeService.findDegree(rowId);
                                doctor.setDegree(degree);

                                doctorService.saveDoctor(doctor);
                            }
                            else if(tableId == 6){
                                System.out.println("Set name");
                                name = getCommand();
                                Degree degree = new Degree();
                                degree.setName(name);
                                degreeService.saveDegree(degree);
                            }
                            else if(tableId == 7){
                                System.out.println("Set name");
                                name = getCommand();
                                Patient patient = new Patient();
                                patient.setName(name);


                                System.out.println("Set password");
                                name = getCommand();
                                Password password = new Password();
                                password.setPass(name);
                                passwordService.savePassword(password);
                                patient.setPassword(password);

                                patientService.savePatient(patient);
                            }
                            else if(tableId == 8){
                                System.out.println("Select doctor");

                                Treatment treatment = new Treatment();
                                writeDoctors(doctorService);
                                rowId = Integer.parseInt(getCommand());
                                Doctor doctor = doctorService.findDoctor(rowId);
                                treatment.setDoctor(doctor);
                                doctor.addTreatment(treatment);

                                writePatients(patientService);
                                rowId = Integer.parseInt(getCommand());
                                Patient patient = patientService.findPatient(rowId);
                                treatment.setPatient(patient);
                                patient.addTreatment(treatment);
                                treatmentService.saveTreatment(treatment);

                            }
                            else if(tableId == 9){
                                System.out.println("Set pass");
                                name = getCommand();
                                Password password = new Password();
                                password.setPass(name);
                                passwordService.savePassword(password);
                            }
                        }


                    } catch (Exception e) {
                        System.out.println("It's not tableId");
                    }

                }
            }

            else if(command.equals("3")){
                while (true){
                    System.out.println("0 - Exit");
                    writeTables();
                    try {
                        tableId = Integer.parseInt(getCommand());
                        if ((tableId < 0) || (tableId > getTablesName().length)) {
                            System.out.println("It's not tableId");
                        }
                        else if (tableId == 0) {
                            System.out.println("Exit");
                            break;
                        }
                        else {
                            if(tableId == 1){
                                writeCountries(countryService);
                                System.out.println("Select id");
                                rowId = Integer.parseInt(getCommand());
                                Country country = countryService.findCountry(rowId);
                                System.out.println("Set new name");
                                name = getCommand();
                                country.setName(name);
                                countryService.updateCountry(country);

                            }
                            else if(tableId == 2){
                                writeCities(cityService);
                                System.out.println("Select id");
                                rowId = Integer.parseInt(getCommand());
                                City city = cityService.findCity(rowId);
                                System.out.println("Set new name");
                                name = getCommand();
                                city.setName(name);
                                writeCountries(countryService);
                                System.out.println("Select country");
                                rowId = Integer.parseInt(getCommand());
                                Country country = countryService.findCountry(rowId);
                                city.setCountry(country);
                                country.addCity(city);
                                cityService.updateCity(city);
                            }

                            else if(tableId == 3){
                                System.out.println("Select hospital");
                                writeHospitals(hospitalService);
                                rowId = Integer.parseInt(getCommand());
                                System.out.println("Set name");
                                name = getCommand();
                                System.out.println("Select city");
                                writeCities(cityService);
                                Integer id = Integer.parseInt(getCommand());
                                try {
                                    City city = cityService.findCity(id);
                                    Hospital hospital = hospitalService.findHospital(rowId);
                                    hospital.setName(name);
                                    hospital.setCity(city);
                                    city.addHospital(hospital);

                                    System.out.println("Select region");
                                    writeRegions(regionService);
                                    rowId = Integer.parseInt(getCommand());
                                    Region region = regionService.findRegion(rowId);
                                    hospital.setRegion(region);
                                    region.addHospital(hospital);
                                    hospitalService.updateHospital(hospital);

                                }catch (Exception e) { System.out.println("Error"); }
                            }
                            else if (tableId == 4){
                                writeRegions(regionService);
                                System.out.println("Select region");
                                rowId = Integer.parseInt(getCommand());
                                System.out.println("Set name");
                                name = getCommand();
                                Region region = regionService.findRegion(rowId);
                                region.setName(name);
                                regionService.updateRegion(region);
                            }
                            else if (tableId == 5){
                                System.out.println("Select doctor");
                                writeDoctors(doctorService);
                                rowId = Integer.parseInt(getCommand());
                                Doctor doctor = doctorService.findDoctor(rowId);

                                System.out.println("Set name");
                                name = getCommand();
                                doctor.setName(name);

                                System.out.println("Set email");
                                String email = getCommand();
                                doctor.setEmail(email);

                                System.out.println("Select Hospital");
                                writeHospitals(hospitalService);
                                rowId = Integer.parseInt(getCommand());
                                Hospital hospital = hospitalService.findHospital(rowId);
                                doctor.setHospital(hospital);


                                System.out.println("Select Degree");
                                writeDegrees(degreeService);
                                rowId = Integer.parseInt(getCommand());
                                Degree degree = degreeService.findDegree(rowId);
                                doctor.setDegree(degree);

                                doctorService.updateDoctor(doctor);
                            }
                            else if(tableId == 6){
                                writeDegrees(degreeService);
                                System.out.println("Select Degree");
                                rowId = Integer.parseInt(getCommand());
                                Degree degree = degreeService.findDegreeById(rowId);
                                System.out.println("Set name");
                                name = getCommand();
                                degree.setName(name);
                                degreeService.updateDegree(degree);
                            }
                            else if(tableId == 7){
                                writePatients(patientService);
                                System.out.println("Select Patient");
                                rowId = Integer.parseInt(getCommand());
                                Patient patient = patientService.findPatient(rowId);
                                System.out.println("Set name");
                                name = getCommand();
                                patient.setName(name);

                                System.out.println("Set password");
                                name = getCommand();
                                Password password = passwordService.findPassword(patient.getPassword().getId());
                                password.setPass(name);
                                passwordService.savePassword(password);
                                patient.setPassword(password);

                                patientService.updatePatient(patient);
                            }
                            else if(tableId == 8){
                                writeTreatments(treatmentService);
                                System.out.println("Select Treatment");
                                rowId = Integer.parseInt(getCommand());
                                Treatment treatment = treatmentService.findTreatment(rowId);

                                System.out.println("Select Doctor");
                                writeDoctors(doctorService);
                                rowId = Integer.parseInt(getCommand());
                                Doctor doctor = doctorService.findDoctor(rowId);
                                doctor.addTreatment(treatment);
                                treatment.setDoctor(doctor);

                                System.out.println("Select Patient");
                                writePatients(patientService);
                                rowId = Integer.parseInt(getCommand());
                                Patient patient = patientService.findPatient(rowId);
                                treatment.setPatient(patient);
                                patient.addTreatment(treatment);

                                patientService.updatePatient(patient);
                            }
                            else if(tableId == 9){
                                System.out.println("Select pass");
                                writePasswords(passwordService);
                                rowId = Integer.parseInt(getCommand());
                                Password password = passwordService.findPassword(rowId);
                                System.out.println("Select pass");
                                name = getCommand();
                                password.setPass(name);
                                passwordService.updatePassword(password);
                            }
                        }


                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
            else if(command.equals("4")){
                while (true){
                    System.out.println("0 - Exit");
                    writeTables();
                    try {
                        tableId = Integer.parseInt(getCommand());
                        if ((tableId < 0) || (tableId > getTablesName().length)) {
                            System.out.println("It's not tableId");
                        }
                        else if (tableId == 0) {
                            System.out.println("Exit");
                            break;
                        }
                        else {
                            if(tableId == 1){
                                writeCountries(countryService);
                                System.out.println("Select id");
                                rowId = Integer.parseInt(getCommand());
                                Country country = countryService.findCountry(rowId);
                                countryService.deleteCountry(country);

                            }
                            else if(tableId == 2){
                                writeCities(cityService);
                                System.out.println("Select id");
                                rowId = Integer.parseInt(getCommand());
                                City city = cityService.findCity(rowId);
                                cityService.deleteCity(city);
                            }
                            else if(tableId == 3){
                                writeHospitals(hospitalService);
                                System.out.println("Select id");
                                rowId = Integer.parseInt(getCommand());
                                Hospital hospital = hospitalService.findHospital(rowId);
                                hospitalService.deleteHospital(hospital);
                            }
                            else if(tableId == 4){
                                writeRegions(regionService);
                                System.out.println("Select id");
                                rowId = Integer.parseInt(getCommand());
                                Region region = regionService.findRegionById(rowId);
                                regionService.deleteRegion(region);
                            }
                            else if(tableId == 5){
                                writeDoctors(doctorService);
                                System.out.println("Select id");
                                rowId = Integer.parseInt(getCommand());
                                Doctor doctor = doctorService.findDoctor(rowId);
                                doctorService.deleteDoctor(doctor);
                            }
                            else if(tableId == 6){
                                writeDegrees(degreeService);
                                System.out.println("Select id");
                                rowId = Integer.parseInt(getCommand());
                                Degree degree = degreeService.findDegreeById(rowId);
                                degreeService.deleteDegree(degree);
                            }
                            else if(tableId == 7){
                                writePatients(patientService);
                                System.out.println("Select Patient");
                                rowId = Integer.parseInt(getCommand());
                                Patient patient = patientService.findPatient(rowId);
                                patientService.deletePatient(patient);
                            }
                            else if(tableId == 8){
                                writeTreatments(treatmentService);
                                System.out.println("Select Treatment");
                                rowId = Integer.parseInt(getCommand());
                                Treatment treatment = treatmentService.findTreatment(rowId);
                                treatmentService.deleteTreatment(treatment);
                            }
                            else if(tableId == 9){
                                System.out.println("Select pass");
                                writePasswords(passwordService);
                                rowId = Integer.parseInt(getCommand());
                                Password password = passwordService.findPassword(rowId);
                                passwordService.deletePassword(password);
                            }
                        }


                    } catch (Exception e) {
                        System.out.println("It's not tableId");
                    }
                }
            }
        }
        }
}

