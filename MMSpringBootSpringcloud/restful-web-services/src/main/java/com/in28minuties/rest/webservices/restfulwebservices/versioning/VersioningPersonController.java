package com.in28minuties.rest.webservices.restfulwebservices.versioning;

import com.in28minuties.rest.webservices.restfulwebservices.versioning.v1.Person;
import com.in28minuties.rest.webservices.restfulwebservices.versioning.v2.Name;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping(value = "/person", produces = "application/vnd.company.app-v1+json")
    public Person getPerson() {
        return new Person("John");
    }

    @GetMapping(value = "person", produces = "application/vnd.company.app-v2+json")
    public com.in28minuties.rest.webservices.restfulwebservices.versioning.v2.Person getPersonV2() {
        return new com.in28minuties.rest.webservices.restfulwebservices.versioning.v2.Person(new Name("John", "Dehere"));
    }
}
