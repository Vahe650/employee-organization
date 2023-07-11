package org.project.model;

import org.project.enums.Status;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "organization")
public class Organization {
    private String name;
    private String creationDate;
    private Status status;
    private List<Employee> employees;

    public Organization() {
        this.employees = new ArrayList<>();
    }

    public Organization(String name, String creationDate, Status status) {
        this.name = name;
        this.creationDate = creationDate;
        this.status = status;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    @XmlElement(name = "creation_date")
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Status getStatus() {
        return status;
    }

    @XmlElement
    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @XmlElement(name = "employee")
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}
