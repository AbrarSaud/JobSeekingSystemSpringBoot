package com.example.jobseekingsystem.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Title cannot be null")
    @Size(min = 5, message = "Length must be more than 4 characters.")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;

    @NotEmpty(message = "Description cannot be null")
    @Column(columnDefinition = "varchar(100) not null")
    private String description;

    @NotEmpty(message = "Location cannot be null")
    @Column(columnDefinition = "varchar(50) not null")
    private String location;

    @NotNull(message = "Salary cannot be null")
    @PositiveOrZero(message = "Salary must be a non-negative number")
    @Column(columnDefinition = "int not null")
    private Integer salary;

    @NotNull(message = "Posting date cannot be null")
    @Column(columnDefinition = "timestamp not null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate postingDate;


}
