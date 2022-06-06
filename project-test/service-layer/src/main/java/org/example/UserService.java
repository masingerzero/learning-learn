package org.example;

public class UserService {
    private RepoDataService repoDataService;

    public UserService(RepoDataService repoDataService) {
        this.repoDataService = repoDataService;
    }

    public void doService() {
        repoDataService.retrieveData();
        System.out.println("UserService.doService");
    }

}
