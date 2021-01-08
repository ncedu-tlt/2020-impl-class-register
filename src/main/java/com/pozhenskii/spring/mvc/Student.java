package com.pozhenskii.spring.mvc;

import com.pozhenskii.spring.mvc.validation.CheckEmail;

import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.Map;

public class Student {
    @Size(min = 2, max = 20, message = "Name must be min 2 symbols!")
    private String name;

    @NotEmpty(message = "Surename is reqired value!")
    @NotBlank(message = "Surename is reqired value!")
    private String surename;
    private Double avarageMark;

    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}", message = "Please use pattern XXX-XX-XX")
    private String phoneNumber;
    private String flow;

    @Max(value = 5000, message = "More then 5000!")
    @Min(value = 500, message = "Mess then 500!")
    private int scholarship;
    private Map <String, String> flows;
    private String prefInScholarship;
    private Map <String, String> prefInScholarships;
    private String[] languages;
    private Map <String, String> languagesList;

    @CheckEmail(value = "@gmail.com", message = "should ens with @gmail.com")
    private String email;

    public Student() {
        flows = new HashMap<>();
        flows.put("IT", "Information Technology");
        flows.put("Math", "Math Class");
        flows.put("Lit", "Litricer Lanser");

        prefInScholarships = new HashMap<>();
        prefInScholarships.put("free", "For free!");
        prefInScholarships.put("scholarship", "Without something!");
        prefInScholarships.put("without something", "Without something!");

        languagesList = new HashMap<>();
        languagesList.put("English", "Eng");
        languagesList.put("Russian", "Rus");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public Double getAvarageMark() {
        return avarageMark;
    }

    public void setAvarageMark(Double avarageMark) {
        this.avarageMark = avarageMark;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public int getScholarship() {
        return scholarship;
    }

    public void setScholarship(int scholarship) {
        this.scholarship = scholarship;
    }

    public Map<String, String> getFlows() {
        return flows;
    }

    public void setFlows(Map<String, String> flows) {
        this.flows = flows;
    }

    public String getPrefInScholarship() {
        return prefInScholarship;
    }

    public void setPrefInScholarship(String prefInScholarship) {
        this.prefInScholarship = prefInScholarship;
    }

    public Map<String, String> getPrefInScholarships() {
        return prefInScholarships;
    }

    public void setPrefInScholarships(Map<String, String> prefInScholarships) {
        this.prefInScholarships = prefInScholarships;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public Map<String, String> getLanguagesList() {
        return languagesList;
    }

    public void setLanguagesList(Map<String, String> languagesList) {
        this.languagesList = languagesList;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surename='" + surename + '\'' +
                ", avarageMark=" + avarageMark +
                ", flow='" + flow + '\'' +
                ", flows=" + flows +
                ", prefInScholarship='" + prefInScholarship + '\'' +
                ", prefInScholarships=" + prefInScholarships +
                '}';
    }
}
