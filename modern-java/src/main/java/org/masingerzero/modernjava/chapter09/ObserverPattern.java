package org.masingerzero.modernjava.chapter09;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args) {
        Subject messageSource = new MessageSource();
        messageSource.register(new MessageStart());
        messageSource.register(new MessageStop());
        messageSource.register(new MessagePause());

        messageSource.notify("start");
        messageSource.notify("stop");
        messageSource.notify("pause");

    }
}

interface Observer {
    void notify(String message);
}

interface Subject {
    void register(Observer observer);
    void notify(String message);
}

class MessageSource implements Subject {
    List<Observer> observers = new ArrayList<>();
    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notify(String message) {
        observers.forEach(observer -> observer.notify(message));
    }
}

class MessageStart implements Observer {
    @Override
    public void notify(String message) {
        if (message.contains("start")) {
            System.out.println("Start!!! notification");
        }
    }
}

class MessageStop implements Observer {
    @Override
    public void notify(String message) {
        if (message.contains("stop")) {
            System.out.println("Stop!!! notification");
        }
    }
}


class MessagePause implements Observer {
    @Override
    public void notify(String message) {
        if (message.contains("pause")) {
            System.out.println("Pause!!! notification");
        }
    }
}
