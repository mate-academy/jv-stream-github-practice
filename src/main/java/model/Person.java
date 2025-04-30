package model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Person {
    private String name;
    private int age;
    private Sex sex;
    private List<Cat> cats;

    public enum Sex {
        MAN, WOMAN
    }

    public Person(String name, int age, Sex sex) {
        this(name, age, sex, new ArrayList<>());
    }

    public Person(String name, int age, Sex sex, List<Cat> cats) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.cats = cats;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public Sex getSex() { return sex; }
    public List<Cat> getCats() { return cats; }

    // Метод 3: Чоловіки від from до to років
    public static List<Person> getRecruitMen(List<Person> people, int fromAge, int toAge) {
        return people.stream()
                .filter(p -> p.getSex() == Sex.MAN)
                .filter(p -> p.getAge() >= fromAge && p.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    // Метод 4: Люди працездатного віку
    public static List<Person> getWorkingPeople(List<Person> people, int fromAge, int maleToAge, int femaleToAge) {
        return people.stream()
                .filter(p -> p.getAge() >= fromAge)
                .filter(p -> (p.getSex() == Sex.MAN && p.getAge() <= maleToAge)
                        || (p.getSex() == Sex.WOMAN && p.getAge() <= femaleToAge))
                .collect(Collectors.toList());
    }

    // Метод 5: Імена котів жінок від femaleAge
    public static List<String> getCatsNamesOfWomen(List<Person> people, int femaleAge) {
        return people.stream()
                .filter(p -> p.getSex() == Sex.WOMAN && p.getAge() >= femaleAge)
                .flatMap(p -> p.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", sex=" + sex + ", cats=" + cats + '}';
    }
}
