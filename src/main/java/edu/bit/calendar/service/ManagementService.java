package edu.bit.calendar.service;

import edu.bit.calendar.model.Employee;

public interface ManagementService {
    void addEmployee(Employee employee);

    int minimumNumberOfRoomsRequired();

}