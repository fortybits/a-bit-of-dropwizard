package edu.bit.calendar.application;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import edu.bit.calendar.dao.EmployeeDao;
import edu.bit.calendar.dao.InviteDao;
import edu.bit.calendar.dao.MeetingDao;
import edu.bit.calendar.provider.InviteServiceProvider;
import edu.bit.calendar.provider.ManagementServiceProvider;
import edu.bit.calendar.provider.MeetingServiceProvider;
import edu.bit.calendar.service.InviteService;
import edu.bit.calendar.service.ManagementService;
import edu.bit.calendar.service.MeetingService;
import edu.bit.calendar.store.EmployeeStore;
import edu.bit.calendar.store.InviteStore;
import edu.bit.calendar.store.MeetingStore;

public class CalendarModule extends AbstractModule {

    private static CalendarConfig calendarConfig;
    private static Injector injector;

    public CalendarModule(CalendarConfig calendarConfig) {
        CalendarModule.calendarConfig = calendarConfig;
    }

    public static synchronized Injector getInjector() {
        if (injector == null) {
            injector = Guice.createInjector(new CalendarModule(calendarConfig));
        }
        return injector;
    }

    @Override
    protected void configure() {
        // config binding
//        bind(StartupConfig.class).toInstance(calendarConfig.getStartUpConfig());

        // dao bindings
        bind(MeetingDao.class).to(MeetingStore.class).in(Singleton.class);
        bind(InviteDao.class).to(InviteStore.class).in(Singleton.class);
        bind(EmployeeDao.class).to(EmployeeStore.class).in(Singleton.class);

        //service bindings
        bind(MeetingService.class).to(MeetingServiceProvider.class).in(Singleton.class);
        bind(ManagementService.class).to(ManagementServiceProvider.class).in(Singleton.class);
        bind(InviteService.class).to(InviteServiceProvider.class).in(Singleton.class);
    }
}