package edu.bit.calendar.provider;

import com.google.inject.Inject;
import edu.bit.calendar.dao.EmployeeDao;
import edu.bit.calendar.model.Employee;
import edu.bit.calendar.service.ManagementService;

public class ManagementServiceProvider implements ManagementService {

    @Inject
    private EmployeeDao employeeDao;

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public int minimumNumberOfRoomsRequired() {
        return 0;
    }
}