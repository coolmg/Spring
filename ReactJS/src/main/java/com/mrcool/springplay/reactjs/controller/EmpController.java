package com.mrcool.springplay.reactjs.controller;

import com.mrcool.springplay.reactjs.model.Employee;
import com.mrcool.springplay.reactjs.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class EmpController {

	@Autowired
	private EmpRepository empRepository;

	@GetMapping("/employees")
	public List<Employee> getAll() {
		return empRepository.findAll();
	}

}
