package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.employee;
import com.example.demo.service.employeeService;



@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class EmployeeController {
	@Autowired
	employeeService service;
	// for the front page
	
	@GetMapping("/")
	public String house() {
		return service.hello();
	}
	
	// returning all Employee
	@GetMapping("/employee")
	public List<employee> listEmployee () {
		return service.getEmployee();
	}
	
	
	// returning all Employee by id 
	@GetMapping("/employee/{id}")
	public employee empId(@PathVariable("id") int id) {
		 return service.getEmployeeId(id);
	}
	
	//adding employee in db
	@PostMapping("/employee/add")
	public void addEmployee(@RequestBody employee emp) {
		service.addEmployee(emp);
	}
	// updating employee in db 
	@PutMapping("/employee/update")
	public void updateEmployee(@RequestBody employee employee) {
		service.updateEmployee(employee);
	}
    //deleting  employee in db 
	@DeleteMapping("/employee/delete/byid/{id}")
	// note :if  @Pathvarible and parameter have same name we don't need mention it explicitly 
	public void deleteById(@PathVariable int id) {
		service.deleteEmployee(id);
	}
	//Erasing all employee data
	@DeleteMapping("/employee/clear")
	public void clearEmployee() {
		service.clearEmployee();
	}
	//this service which has been passed inside the controller is a specified with native query in repository checkout the repository  
	@DeleteMapping("/employee/delete/{dep}")
	public void deleteByTechnology(@PathVariable("dep") String department) {
		service.clearByTech(department);
	}
	}
	


