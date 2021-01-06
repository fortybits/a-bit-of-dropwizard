package edu.bit.calendar.store;

import edu.bit.calendar.dao.InviteDao;
import edu.bit.calendar.model.Invite;

public class InviteStore implements InviteDao {

    @Override
    public String createInvite(Invite invite) {
        return invite.getInviteId();
    }
}