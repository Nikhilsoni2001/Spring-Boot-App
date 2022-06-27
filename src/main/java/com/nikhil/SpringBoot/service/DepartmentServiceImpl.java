package com.nikhil.SpringBoot.service;

import com.nikhil.SpringBoot.error.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikhil.SpringBoot.entity.Department;
import com.nikhil.SpringBoot.repository.DepartmentRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public List<Department> fetchDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		Optional<Department> department = departmentRepository.findById(departmentId);
		if(department.isEmpty()) throw new DepartmentNotFoundException("Department Not Available!!");

		return department.get();
	}
	@Override
	public Department getDepartmentByName(String departmentName) {
		return departmentRepository.getByDepartmentNameIgnoreCase(departmentName);
	}
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}
	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		Department depDb = departmentRepository.findById(departmentId).orElse(null);

		if(Objects.nonNull(department.getDepartmentName())
				&& !"".equalsIgnoreCase(department.getDepartmentName())) {
            assert depDb != null;
            depDb.setDepartmentName(department.getDepartmentName());
        }

		if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            assert depDb != null;
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }

		if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            assert depDb != null;
            depDb.setDepartmentCode(department.getDepartmentCode());
        }

        assert depDb != null;
        return departmentRepository.save(depDb);
	}
	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
	}
}
