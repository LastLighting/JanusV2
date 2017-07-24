package topprogersgroup.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import topprogersgroup.entity.Employee;
import topprogersgroup.entity.User;
import topprogersgroup.repository.EmployeeRepository;
import topprogersgroup.repository.UserRepository;
import topprogersgroup.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(Employee employee) {
        employee.setDeleted(true);
        employeeRepository.save(employee);
        Optional<User> user = userRepository.findUserByIdAndIsDeleted(employee.getUser().getId(), false);
        user.get().setDeleted(true);
        userRepository.save(user.get());
    }

    public Employee edit(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployeeList() {
        return employeeRepository.findByIsDeleted(false);
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findByIdAndIsDeleted(id, false);
    }

    @Override
    public Employee findEmployeeByEmail(String email, boolean isDeleted) {
        return employeeRepository.findByUserEmailAndIsDeleted(email,isDeleted);
    }
}
