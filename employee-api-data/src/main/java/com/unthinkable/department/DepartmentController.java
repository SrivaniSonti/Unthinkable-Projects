package com.unthinkable.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/get")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping(value ="/departments")
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments(); 
	}
	
	@GetMapping(value = "/departments/{id}")
	public Department getDepartment(@PathVariable String id) {
		return departmentService.getDepartment(id);
	}
	
	@PostMapping(value = "/departments")
	public void addDepartment(@RequestBody Department department) {
		departmentService.addDepartment(department);
	}
	
	@PutMapping( value = "/departments/{id}")
	public void updateDepartment(@RequestBody Department department ,@PathVariable String id) {
		departmentService.updateDepartment(id,department);
	}

	@DeleteMapping( value = "/departments/{id}")
	public void deleteDepartment(@PathVariable String id) {
		departmentService.deleteDepartment(id);
	}
}