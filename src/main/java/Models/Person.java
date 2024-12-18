package Models;

import lombok.Getter;

public abstract class Person {
    @Getter
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
