package practice;

import java.util.function.Predicate;
import model.Person;

public class PersonPredicates {
    public static Predicate<Person> isEligibleMan(int fromAge, int maleToAge) {
        return p -> p.getSex().equals(Person.Sex.MAN)
                && p.getAge() >= fromAge
                && p.getAge() <= maleToAge;
    }

    public static Predicate<Person> isEligibleWoman(int fromAge, int femaleToAge) {
        return p -> p.getSex().equals(Person.Sex.WOMAN)
                && p.getAge() >= fromAge
                && p.getAge() <= femaleToAge;
    }
}
