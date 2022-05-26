package com.example.universetechapidemoapp.model;

import com.example.universetechapidemoapp.enums.Job;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "firstName is mandatory")
    @Column(nullable = false, name = "first_name")
    private String firstName;

    @NotBlank(message = "lastName is mandatory")
    @Column(nullable = false, name = "last_name")
    private String lastName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    @Column(nullable = false, name = "date_of_birth")
    private LocalDate dateOfBirth;

    @NotBlank(message = "phone is mandatory")
    @Column(nullable = false, name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "job")
    private Job job;
}
