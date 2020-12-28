package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class People {
    private String name;
    private int age;
    private Sex sex;
    private List<Cat> cats;

    public People(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        cats = new ArrayList<>();
    }

    public People(String name, int age, Sex sex, List<Cat> cats) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.cats = cats;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public List<Cat> getCats() {
        return cats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        People people = (People) o;
        return age == people.age
            && Objects.equals(name, people.name)
            && sex == people.sex
            && Objects.equals(cats, people.cats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex, cats);
    }

    @Override
    public String toString() {
        return "People{"
            + "name='" + name + '\''
            + ", age=" + age
            + ", sex=" + sex
            + ", catList=" + cats
            + '}';
    }

    public enum Sex {
        MAN, WOMEN
    }
}
