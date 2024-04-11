package practice;

import model.Person;

public class SexAndFromAgePredicate {
    public static boolean test(Person person, Person.Sex sex, int fromAge) {
        return person.getSex() == sex
                && person.getAge() >= fromAge;
    }
}
