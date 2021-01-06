package edu.bit.calendar.store;

import edu.bit.calendar.dao.EmployeeDao;
import edu.bit.calendar.model.Employee;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeStore implements EmployeeDao {

    @Override
    public void addEmployee(Employee employee) {
        log.info("Employee added with details {}", employee);
    }
}