package com.nikhil.SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nikhil.SpringBoot.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department getByDepartmentName(String departmentName);
    Department getByDepartmentNameIgnoreCase(String departmentName);
}
