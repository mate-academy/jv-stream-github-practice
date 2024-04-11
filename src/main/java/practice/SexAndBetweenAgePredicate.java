package practice;

import model.Person;

public class SexAndBetweenAgePredicate {
    public static boolean test(Person person, Person.Sex sex, int fromAge, int toAge) {
        return person.getSex() == sex
                && person.getAge() >= fromAge
                && person.getAge() <= toAge;
    }
}
