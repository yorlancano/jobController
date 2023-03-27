package com.employee_Management.employment.Controllers;

import com.employee_Management.employment.Exeptions.ResourceNotFoundExeption;
import com.employee_Management.employment.Model.Employee;
import com.employee_Management.employment.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("")
public class ControllerEmployee {
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping("/employee")
    public List<Employee> listAllemployees(){
        return employeeRepository.findAll();

    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    @GetMapping("/employee/{id}")

    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("not exists employee with id: " + id));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> upadateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("not exists employee with id: " + id));
        employee.setName(employeeDetails.getName());
        employee.setLast_name(employeeDetails.getLast_name());
        employee.setEmail(employeeDetails.getEmail());

        Employee UpdateEmployee = employeeRepository.save(employee);

        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){  
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("not exists employee with id: " + id));

        employeeRepository.delete(employee);
        Map<String, Boolean> answer = new HashMap<>();
        answer.put("delete",Boolean.TRUE);

        return ResponseEntity.ok(answer);
    }
}
