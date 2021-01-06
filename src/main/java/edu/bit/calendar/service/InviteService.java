package edu.bit.calendar.service;

import java.util.Set;

public interface InviteService {

    String createInvite(Set<String> employeeIds);
}