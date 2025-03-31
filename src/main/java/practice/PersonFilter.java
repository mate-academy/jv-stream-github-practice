package practice;

import java.util.function.Predicate;
import model.Person;

public class PersonFilter {
    public static Predicate<Person> filterMan(int fromAge, int maleToAge) {
        return p -> p.getSex() == Person.Sex.MAN
                && p.getAge() >= fromAge
                && p.getAge() <= maleToAge;
    }

    public static Predicate<Person> filterWoman(int fromAge, int femaleToAge) {
        return p -> p.getSex() == Person.Sex.WOMAN
                && p.getAge() >= fromAge
                && p.getAge() <= femaleToAge;
    }
}
