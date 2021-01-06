package edu.bit.calendar.store;

import edu.bit.calendar.dao.MeetingDao;
import edu.bit.calendar.model.Meeting;

import java.util.Arrays;
import java.util.List;

public class MeetingStore implements MeetingDao {

    @Override
    public List<Meeting> findAllMeeting(String employeeId) {
        return Arrays.asList(
                Meeting.builder().meetingId("Meeting1").build(),
                Meeting.builder().meetingId("Meeting2").build(),
                Meeting.builder().meetingId("Meeting3").build(),
                Meeting.builder().meetingId("Meeting4").build()
        );
    }

    @Override
    public boolean createMeeting(Meeting meeting) {
        return true;
    }
}