package com.bezkoder.spring.security.postgresql.repository;

import com.bezkoder.spring.security.postgresql.models.Employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    static void deleteEmployeeById(Long id) {

    }
@Transactional
    void deleteEmployeeByEmployeeId(Long id);

    Optional <Employee> findByEmployeeId (Long id);

    Employee getByNamaLengkap(String namaLengkap);

    Employee findByNamaLengkap(String namaLengkap);




}

