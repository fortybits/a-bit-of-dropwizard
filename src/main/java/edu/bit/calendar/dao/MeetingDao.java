package edu.bit.calendar.dao;

import edu.bit.calendar.model.Meeting;

import java.util.List;

public interface MeetingDao {

    List<Meeting> findAllMeeting(String employeeId);

    boolean createMeeting(Meeting meeting);
}
