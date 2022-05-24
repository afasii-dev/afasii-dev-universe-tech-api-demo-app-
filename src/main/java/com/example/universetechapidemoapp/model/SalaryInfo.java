package com.example.universetechapidemoapp.model;

import lombok.*;

import javax.persistence.*;
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

    @Column(nullable = false)
    private Integer amount;

    @Column(name = "received_date", nullable = false)
    private LocalDate receivedDate;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
