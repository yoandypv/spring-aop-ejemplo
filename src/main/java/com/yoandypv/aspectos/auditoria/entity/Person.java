package com.yoandypv.aspectos.auditoria.entity;

public class Person {

    private String name;
    private int edad;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", edad=" + edad +
                '}';
    }
}
