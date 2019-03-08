package com.jh.litepaltest.model;


import org.litepal.crud.LitePalSupport;

/**
 * Author: Created by Real_Man.
 * Version: 1.0
 * Data: 2016/9/29.
 * Other:
 */

public class Person extends LitePalSupport {
    //姓名
    private String name;

    //学号
    private String nubmer;

    //年龄
    private int age;

    public Person() {
    }

    public Person(String name, String nubmer, int age) {
        this.name = name;
        this.nubmer = nubmer;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNubmer() {
        return nubmer;
    }

    public void setNubmer(String nubmer) {
        this.nubmer = nubmer;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", nubmer='" + nubmer + '\'' +
                ", age=" + age +
                '}';
    }
}
