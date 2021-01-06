package edu.bit.calendar.application;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.bit.calendar.resources.InviteResource;
import edu.bit.calendar.resources.ManagementResource;
import edu.bit.calendar.resources.MeetingResource;
import io.dropwizard.Application;
import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalendarApplication extends Application<CalendarConfig> {

    private static Injector injector;

    // Application entry point
    public static void main(String[] args) throws Exception {
        new CalendarApplication().run(args);
        log.info("Application Started!");
    }

    @Override
    public void initialize(Bootstrap<CalendarConfig> calendarConfigurationBootstrap) {
        calendarConfigurationBootstrap.addBundle(new SwaggerBundle<>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(CalendarConfig calendarConfig) {
                return calendarConfig.getSwaggerBundleConfiguration();
            }
        });

    }

    public void run(CalendarConfig configuration, Environment environment) {

        // object mapper configuration
        environment.getObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // inject configuration for a custom module
        injector = Guice.createInjector(new CalendarModule(configuration));

        // register filters and health checks
        environment.healthChecks().register("HealthCheck", new CalendarHealthCheck());

        // register resources
        environment.jersey().register(injector.getInstance(MeetingResource.class));
        environment.jersey().register(injector.getInstance(ManagementResource.class));
        environment.jersey().register(injector.getInstance(InviteResource.class));

        // register exception mappers
        environment.jersey().register(new JsonProcessingExceptionMapper(true));

        // can build all cache if required
    }
}