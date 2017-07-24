package topprogersgroup.service;


import topprogersgroup.entity.Employee;

import java.util.List;

public interface EmployeeService extends BaseService<Employee> {
    List<Employee> getEmployeeList();
    Employee getEmployeeById(int id);
    Employee findEmployeeByEmail(String email,boolean isDeleted);
}
