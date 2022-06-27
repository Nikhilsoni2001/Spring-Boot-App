package com.nikhil.SpringBoot.service;

import com.nikhil.SpringBoot.entity.Department;
import com.nikhil.SpringBoot.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
	List<Department> fetchDepartments();
	Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;
	Department getDepartmentByName(String departmentName);
	Department saveDepartment(Department department);
	Department updateDepartment(Long departmentId, Department department);
	void deleteDepartmentById(Long id);

}
