package org.project.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "organizations")
public class Organizations {
    private List<Organization> organizations;

    public List<Organization> getOrganizations() {
        return organizations;
    }

    @XmlElement(name = "organization")
    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }
}