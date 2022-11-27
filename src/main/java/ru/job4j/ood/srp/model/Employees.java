package ru.job4j.ood.srp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Employees")

public class Employees {

    private List<Employee> employee;

    public Employees() {
    }

    public Employees(List<Employee> employees) {
        this.employee = employees;
    }
    @XmlElement(name = "employee")
    public List<Employee> getEmployees() {
        return employee;
    }

    public void setEmployees(List<Employee> employees) {
        this.employee = employees;
    }
}
