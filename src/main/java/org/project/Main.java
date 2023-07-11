package org.project;

import org.project.enums.Status;
import org.project.model.Employee;
import org.project.model.Organization;
import org.project.model.Organizations;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Organization> organization = createOrganization();
        serialize(organization);

        try {
            JAXBContext context = JAXBContext.newInstance(Organizations.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            File xmlFile = new File("src/main/resources/organization.xml");
            Organizations organizationsWrapper = (Organizations) unmarshaller.unmarshal(xmlFile);

            List<Organization> organizations = organizationsWrapper.getOrganizations();

            for (Organization org : organizations) {
                if (org.getStatus() == Status.OPEN) {
                    System.out.println("Title: " + org.getName());
                    System.out.println("Date create: " + org.getCreationDate());
                    System.out.println("Employees:");
                    for (Employee employee : org.getEmployees()) {
                        System.out.println(" - " + employee.getName());
                    }
                    System.out.println();
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    static List<Organization> createOrganization() {
        List<Organization> organizations = new ArrayList<>();

        Organization org1 = new Organization("Organization1", "2021-01-01", Status.OPEN);
        org1.addEmployee(new Employee("Alex Alexanyan", "1990-01-01"));
        org1.addEmployee(new Employee("Armen Armenyan", "1995-05-05"));

        Organization org2 = new Organization("Organization1", "2022-02-02", Status.CLOSED);
        org2.addEmployee(new Employee("Ivan Ivanov", "1985-10-10"));

        organizations.add(org1);
        organizations.add(org2);
        return organizations;
    }

    static void serialize(List<Organization> organizations) {
        try {
            JAXBContext context = JAXBContext.newInstance(Organizations.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            Organizations organizationsWrapper = new Organizations();
            organizationsWrapper.setOrganizations(organizations);

            marshaller.marshal(organizationsWrapper, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
