package model;

import java.util.function.Predicate;

public class ValidPerson implements Predicate<Person> {
    private final int fromAge;
    private final int toAge;
    private final Person.Sex sex;

    public ValidPerson(int fromAge, int toAge, Person.Sex sex) {
        this.fromAge = fromAge;
        this.toAge = toAge;
        this.sex = sex;
    }

    @Override
    public boolean test(Person person) {
        return person.getAge() >= fromAge
                && person.getAge() <= toAge
                && person.getSex() == sex;
    }
}
