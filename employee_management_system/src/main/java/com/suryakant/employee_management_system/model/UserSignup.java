package com.suryakant.employee_management_system.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserSignup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String position;

    @Embedded
    private EmbedContact contact;

    // Getters and Setters

}

@Embeddable
@Setter
@Getter
class   EmbedContact {
    private String email;
    private String phone;

    // Getters and Setters

//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email; }
//
//    public String getPhone() { return phone; }
//    public void setPhone(String phone) { this.phone = phone; }
}
