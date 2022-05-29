package com.manning.sbip.main;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

import java.util.Date;

public class ApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
      System.out.println("***Masinger Application Starting Event logged at "+new Date(event.getTimestamp()));
    }
}
