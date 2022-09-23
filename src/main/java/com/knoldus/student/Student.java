package com.knoldus.student;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Student extends PanacheMongoEntity {

    public String name;
    public String course;

    public Student() {

    }

    public Student(String name, String course) {
        this.name = name;
        this.course = course;
    }

}
