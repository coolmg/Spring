package com.mrcool.springplay.reactjs.repository;

import com.mrcool.springplay.reactjs.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Long> {

}
