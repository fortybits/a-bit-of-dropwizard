package edu.bit.calendar.request;

import lombok.Getter;

import java.util.Set;

@Getter
public class InviteRequest {
    Set<String> employeeIds;
}