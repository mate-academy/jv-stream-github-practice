package practice;

import java.util.function.Predicate;
import model.Person;

public class PersonValidator {
    public static Predicate<Person> isManBetweenAges(int fromAge, int toAge) {
        return p -> p.getSex() == Person.Sex.MAN
                && p.getAge() >= fromAge
                && p.getAge() <= toAge;
    }

    public static Predicate<Person> selectPeopleByAge(int fromAge, int maleToAge, int femaleToAge) {
        Predicate<Person> isManBetweenAges = PersonValidator.isManBetweenAges(fromAge, maleToAge);

        return p -> {
            int ageLimit = (p.getSex() == Person.Sex.MAN) ? maleToAge : femaleToAge;
            return p.getAge() >= fromAge && p.getAge() <= ageLimit;
        };
    }

    public static Predicate<Person> isElderlyWoman(int femaleAge) {
        return p -> p.getSex() == Person.Sex.WOMAN && p.getAge() >= femaleAge;
    }
}

