package com.example.universetechapidemoapp.model;

import com.example.universetechapidemoapp.enums.Status;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
