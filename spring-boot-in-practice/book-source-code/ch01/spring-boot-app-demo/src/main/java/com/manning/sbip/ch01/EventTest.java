package com.manning.sbip.ch01;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

public class EventTest {

    @EventListener(ApplicationReadyEvent.class)
    public void applicationTestingEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("the event source is " + applicationReadyEvent.getSource());

    }


}
