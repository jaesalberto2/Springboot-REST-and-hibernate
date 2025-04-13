package com.alberto.cruddemo.rest;


import com.alberto.cruddemo.dao.EmployeeDAO;
import com.alberto.cruddemo.entity.Employee;
import com.alberto.cruddemo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
/*
    private EmployeeDAO employeeDAO;
*/
    private ObjectMapper objectMapper;
    //constructor injection

    public EmployeeRestController(EmployeeService theEmployeeService, ObjectMapper theObjectMapper) {
        employeeService = theEmployeeService;
        objectMapper = theObjectMapper;
    }

    private EmployeeService employeeService;
    // quick and dirty: expose employee dao
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }
    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }

    // add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        // save the employee
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // add mapping fo PATCH /employees/{employeeId} - patch employee ... partial update
    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId,
                                  @RequestBody Map<String, Object> patchPayload) {
        Employee tempEmployee = employeeService.findById(employeeId);
        //throw exception if null
        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        //throw exception if request body contains id key
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Cannot update id field");
        }
        Employee patchedEmployee = apply(patchPayload, tempEmployee);
        Employee dbEmployee = employeeService.save(patchedEmployee);
        return dbEmployee;
    }

    private Employee apply(Map<String, Object> patchPayload, Employee tempEmployee) {

        // Convert the employee object to a  json object node
        ObjectNode employeeNode = objectMapper.convertValue(tempEmployee, ObjectNode.class);
        // Conver the patch payload to a json object node
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
        // Merge the two nodes
        employeeNode.setAll(patchNode);

        return  objectMapper.convertValue(employeeNode, Employee.class);

    }
    // add mapping for DELETE /employees/{employeeId} - delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);
        //throw exception if null
        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }

}
