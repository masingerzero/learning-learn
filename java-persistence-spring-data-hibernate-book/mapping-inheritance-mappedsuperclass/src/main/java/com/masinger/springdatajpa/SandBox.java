package com.masinger.springdatajpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

public class SandBox {
}


@MappedSuperclass
class ParentAbstractClass {
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;

    private String foo;

}

@Entity
class EntityBar extends ParentAbstractClass {
    String bar;
}

@Entity
class EntityBaz extends ParentAbstractClass {
    String baz;
}