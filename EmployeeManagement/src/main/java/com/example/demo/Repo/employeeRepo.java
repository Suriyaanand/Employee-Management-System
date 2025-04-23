package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.employee;

public interface employeeRepo extends JpaRepository<employee,Integer>{
@Modifying
@Transactional
 @Query("DELETE FROM employee e WHERE e.Department = :Department")
public void deleteByDepartment(@Param("Department") String Department);
}
