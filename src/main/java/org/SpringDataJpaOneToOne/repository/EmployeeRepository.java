package org.SpringDataJpaOneToOne.repository;

import org.SpringDataJpaOneToOne.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findOneByName(String name);
}
