package com.bezkoder.spring.security.postgresql.controllers;

import com.bezkoder.spring.security.postgresql.models.Employee;
import com.bezkoder.spring.security.postgresql.repository.EmployeeRepository;
import com.bezkoder.spring.security.postgresql.security.exception.ResourceAlreadyExistException;
import com.bezkoder.spring.security.postgresql.security.exception.ResourceDoseNotExistException;
import com.bezkoder.spring.security.postgresql.security.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort.*;


import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/emp")

public class EmployeeController {

@Autowired
EmployeeRepository employeeRepository;

    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }



    @GetMapping("/find/{id}")
    public Employee getEmployee(@PathVariable Long id) throws ResourceDoseNotExistException {

        Employee employee = employeeService.findById(id);
        return employee;
    }

    @GetMapping("all")
    public List<Employee> getEmployee() {

        List<Employee> employeeList= employeeService.findAll();
        return employeeList;
    }


    @RequestMapping( value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

        System.out.println(employee.getTanggalLahir());
        try {
            Employee addEmployee = employeeService.addEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(addEmployee);
        } catch (ResourceAlreadyExistException e) {
            return ResponseEntity.badRequest().body(null);
        }
    catch (Exception e){ e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(employee);
    }
    }


    @PutMapping("/update/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee)
            throws ResourceDoseNotExistException {
        return employeeService.updateEmployee(id,employee);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);

        }





    @GetMapping("/sortedemployee")
    public ResponseEntity<List<Employee>> getAllEmployee(@RequestParam(defaultValue = "namaLengkap,ASC") String[] sort) {

        try {
            List<Order> orders = new ArrayList<Order>();

            if (sort[0].contains(",")) {
                // will sort more than 2 fields
                // sortOrder="field, direction"
                for (String sortOrder : sort) {
                    String[] _sort = sortOrder.split(",");
                    orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
                }
            }
//            else {
//                // sort=[field, direction]
//                orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
//            }

            List<Employee> employees = employeeRepository.findAll(Sort.by(orders));

            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pageemployee")
    public ResponseEntity<Map<String, Object>> getAllTutorialsPage(
//            @RequestParam(required = false) String namaLengkap,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "namaLengkap,desc") String[] sort) {

        try {
            List<Sort.Order> orders = new ArrayList<Sort.Order>();

            if (sort[0].contains(",")) {
                // will sort more than 2 fields
                // sortOrder="field, direction"
                for (String sortOrder : sort) {
                    String[] _sort = sortOrder.split(",");
                    orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
                }
            } else {
                // sort=[field, direction]
                orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
            }

            List<Employee> employees = new ArrayList<Employee>();
            Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

            Page<Employee> pageTuts;

            pageTuts = employeeRepository.findAll(pagingSort);

            employees = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("employees", employees);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }










    }

