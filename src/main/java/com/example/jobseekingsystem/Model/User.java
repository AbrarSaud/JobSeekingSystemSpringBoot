package com.example.jobseekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
//@Check(constraints = "check (role ='JOB_SEEKER' or role ='EMPLOYER')")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name cannot be null")
    @Size(min = 5, message = "Length must be more than 4 characters.")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Name must contain only letters")

    @Column(columnDefinition = "varchar(10) not null")
    private String name;

    @NotEmpty(message = "Email cannot be null")
    @Email
    @Column(columnDefinition = "varchar(225) not null unique")
    private String email;

    @NotEmpty(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Column(columnDefinition = "varchar(100) not null")
    private String password;

    @NotNull(message = "Age cannot be null")
    @Min(value = 22, message = "Age must be more than 21")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "Role cannot be null")
    @Pattern(regexp = "JOB_SEEKER|EMPLOYER", message = "Role Must be either \"JOB_SEEKER\" or \"EMPLOYER\" only")
    @Column(columnDefinition = "varchar(10) not null")
    private String role;

}
