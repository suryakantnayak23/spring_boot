package com.suryakant.employee_management_system.model;//import javax.persistence.*;
import com.suryakant.employee_management_system.model.Company;
import com.suryakant.employee_management_system.model.Contact;
import com.suryakant.employee_management_system.model.Project;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String position;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Project> projects;

    // Getters and setters
}
