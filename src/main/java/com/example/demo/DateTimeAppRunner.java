package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.ResourceBundle;

@Slf4j
@Component
public class DateTimeAppRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        ZoneId zoneId = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(2015, 1, 20, 6, 15, 30, 200, zoneId);

        log.info("Local date {}\nLocal time {}\nLocal date time {}\nZoned date time {}", localDate, localTime, localDateTime, zonedDateTime);
        log.info("US zoned date time {}", zonedDateTime1);

        log.info("Period {}", Period.ofWeeks(5));
        LocalTime localTime1 = LocalTime.of(23, 50);
        log.info("Local time {}", localTime1.plusHours(1));
        localDate.plus(Period.ofMonths(1));
        log.info("Period {}", Period.of(1, 2, 3));
        log.info("Duration {}", Duration.of(5, ChronoUnit.DAYS));

        //Day time saving
        LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time = LocalTime.of(1, 30);
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);
        System.out.println(dateTime); // 2016–03–13T01:30–05:00[US/Eastern]
        dateTime = dateTime.plusHours(1);
        System.out.println(dateTime); // 2016–03–13T03:30–04:00[US/Eastern]

        Locale locale = Locale.getDefault();
        log.info("Default locale {}", locale);
        log.info("German locale {}", Locale.GERMAN);
        log.info("Germany locale {}", Locale.GERMANY);
        Locale locale1 = (new Locale.Builder())
                .setRegion("US")
                .setLanguage("en")
                .build();

        Locale us = new Locale("en", "US");
        Locale france = new Locale("fr", "FR");
        Locale englishCanada = new Locale("en", "CA");
        Locale frenchCanada = new Locale("fr", "CA");

        printProperties(us);
        printProperties(france);
    }

    public void printProperties(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("zoo", locale);
        log.info("Hello {}", rb.getString("hello") );
        log.info("Open {}", rb.getString("open") );
    }

}
