package com.example.universetechapidemoapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "salaries_info")
public class SalaryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Max(value = 100000, message = "Max value is 100000")
    @Column(nullable = false)
    private Integer amount;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    @Column(name = "received_date", nullable = false)
    private LocalDate receivedDate;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
