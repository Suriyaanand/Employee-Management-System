package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.employee;
import com.example.demo.Repo.employeeRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class employeeService {
	
	@Autowired
	employeeRepo repo;
	
	
	//FOR the Front page 
	public String hello() {
		return "Hello And Welcome To My Employee System Management Project";
	}
	
	//get Employee details
	public List<employee> getEmployee(){
		return repo.findAll();
	}
	//get Employee by id
	public employee getEmployeeId(Integer id) {
		return repo.findById(id).orElseThrow(()->new EntityNotFoundException("Not Found"));
	}
	
	//add employee
	public employee addEmployee(employee employee){
		return  repo.save(employee);

	}

	// update employee
	public employee updateEmployee(employee employee) {
		return repo.save(employee);
	}
	
	// delete employee by id 
	public void deleteEmployee(int id ) {
		 repo.deleteById(id);
	}
    //Erasing all employee data
	public void clearEmployee() {
		repo.deleteAll();
	}
	//Erasing employee data by categorizing with department
	public void clearByTech(String department) {
		repo.deleteByDepartment(department);
	}
	}

