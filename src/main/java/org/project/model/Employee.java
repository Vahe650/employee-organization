package org.project.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "employee")
@XmlType(namespace = "https://www.example.org/employee")

public class Employee {
    private String name;
    private String birthDate;

    public Employee() {
    }

    public Employee(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @XmlElement(name = "birth_date")
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
