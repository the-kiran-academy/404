package com.tka.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.model.Employee;

@RestController
@RequestMapping("/api")
public class TestController {

	List<Employee> list = new ArrayList<Employee>();

	public TestController() {
		list.add(new Employee(101, "AA", 56));
		list.add(new Employee(102, "BB", 45));
		list.add(new Employee(103, "CC", 36));
		list.add(new Employee(104, "DD", 67));
		list.add(new Employee(105, "EE", 37));
	}

	// user want to retrieve such a employee (data) whose id=104
	// localhost:8080/get-employee/104

	@GetMapping("/get-employee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		Employee employee = list.stream().filter(emp -> emp.getId() == id).findFirst().get();
		return employee;
	}

	// user want to retrieve such a employee (data) whose name=CC
	// localhost:8080/get-employee-byname?ename=CC

	@GetMapping("/get-employee-byname")
	public Employee getEmployee(@RequestParam String ename) {
		Employee employee = list.stream().filter(emp -> emp.getName().equalsIgnoreCase(ename)).findFirst().get();
		return employee;
	}

	// user want to add new employee in existing list
	// localhost:8080/api/add-employee

	@PostMapping("/add-employee")
	public String addEmployee(@RequestBody Employee employee) {

		list.add(employee);

		return "Employee Added !!";

	}
	
	@GetMapping("/all")
	public List<Employee> getAllEmp() {
		return list;
	}

}
