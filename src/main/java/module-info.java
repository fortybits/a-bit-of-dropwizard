module a.bit.of.dropwizard {
    requires com.fasterxml.jackson.databind;
    requires com.google.common;
    requires com.google.guice;
    requires dropwizard.core;
    requires dropwizard.jersey;
    requires dropwizard.swagger;
    requires lombok;

    exports edu.bit.calendar.application;
}