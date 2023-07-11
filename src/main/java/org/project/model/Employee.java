package org.project.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
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
