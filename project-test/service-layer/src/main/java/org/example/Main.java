package org.example;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService(new RepoDataService());
        userService.doService();

    }
}