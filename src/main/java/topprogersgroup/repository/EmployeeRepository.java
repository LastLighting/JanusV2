package topprogersgroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import topprogersgroup.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByIsDeleted(boolean isDeleted);
    Employee findByIdAndIsDeleted(int id, boolean isDeleted);
    Employee findByUserEmailAndIsDeleted(String email,boolean isDeleted);
}
