package com.example.universetechapidemoapp.model;

import com.example.universetechapidemoapp.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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

    @Min(value = 3000)
    @Max(value = 100000)
    @Column(name = "current_salary")
    private Integer currentSalary;

    @Min(value = 3000)
    @Max(value = 100000)
    @Column(name = "scheduled_salary")
    private Integer scheduledSalary;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    @Column(name = "scheduled_date")
    private LocalDate scheduledDate;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
}
