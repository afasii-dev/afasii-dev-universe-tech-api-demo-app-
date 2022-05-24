package com.example.universetechapidemoapp.model;

import com.example.universetechapidemoapp.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "salary_manager")
public class SalaryManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "current_salary")
    private Integer currentSalary;

    @Column(name = "scheduled_salary")
    private Integer scheduledSalary;

    @Column(name = "scheduled_date")
    private LocalDate scheduledDate;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
}
