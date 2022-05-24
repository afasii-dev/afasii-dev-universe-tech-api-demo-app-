package com.example.universetechapidemoapp.repository;

import com.example.universetechapidemoapp.model.SalaryInfo;
import org.springframework.data.repository.CrudRepository;

public interface SalaryRepository extends CrudRepository<SalaryInfo, Long> {
}
