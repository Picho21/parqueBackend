package com.todocode.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todocode.demo.Entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, String>{
    
    @Query ("SELECT p FROM Employee p WHERE p.dni = :dni") //éste último es el q llega por parametro
    public Employee buscarPorid(@Param("dni")String dni);
    
}
