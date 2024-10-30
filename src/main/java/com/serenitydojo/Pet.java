package com.serenitydojo;

public abstract class Pet {

    public String name;
    public int age;

    public Pet (String name, int age) {

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract String play();

}
