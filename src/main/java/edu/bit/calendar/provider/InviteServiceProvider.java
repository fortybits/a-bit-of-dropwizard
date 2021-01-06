package edu.bit.calendar.provider;

import com.google.inject.Inject;
import edu.bit.calendar.dao.InviteDao;
import edu.bit.calendar.service.InviteService;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.UUID;

@Slf4j
public class InviteServiceProvider implements InviteService {

    @Inject
    private InviteDao inviteDao;

    @Override
    public String createInvite(Set<String> employeeIds) {
        log.info("Invite created successfully!");
        return UUID.randomUUID().toString();
    }
}