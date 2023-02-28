package org.masingerzero.modernjava.chapter12;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;


public class Test {
    public static void main(String[] args) {
        Hour hour = Hour.of(10);
        hour = hour.add(3);
        
        System.out.println(hour);
    }

    @Data
    public static class Hour {
        private final Integer hour;

        public static Hour of(Integer hour) {
            return new Hour(hour);
        }
        private Hour (Integer hour) {
            this.hour = hour;
        }

        public Hour add(Integer hours) {
            return Hour.of(this.hour + hours);
        }

        public Hour minus(Integer hours) {
            return Hour.of(this.hour - hours);
        }
    }
}
