module a.bit.of.dropwizard {
    requires org.slf4j;
    requires com.fasterxml.jackson.databind;
    requires com.google.common;
    requires com.google.guice;
    requires dropwizard.core;
    requires dropwizard.jersey;
    requires lombok;

    requires java.validation;
    requires java.ws.rs;
    requires com.codahale.metrics.health;
    requires com.codahale.metrics.annotation;

    requires dropwizard.swagger;
    requires swagger.annotations;

    exports edu.bit.calendar.application;
}