package practice;

import model.Person;

public class BetweenAgeBasedOnSexPredicate {
    public static boolean test(Person person, int fromAge, int toMaleAge, int toFemaleAge) {
        return person.getAge() >= fromAge
                & (person.getSex() == Person.Sex.MAN
                ? person.getAge() <= toMaleAge : person.getAge() <= toFemaleAge);
    }
}
