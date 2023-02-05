package practice;

import java.util.function.Predicate;
import model.Person;

public class WorkablePeopleValidator implements Predicate<Person> {
    public boolean check(Person p, int fromAge, int femaleToAge, int maleToAge) {
        return p.getSex() == Person.Sex.WOMAN && p.getAge() >= fromAge && p.getAge() <= femaleToAge
                || p.getSex() == Person.Sex.MAN && p.getAge() >= fromAge && p.getAge() <= maleToAge;
    }

    @Override
    public boolean test(Person person) {
        return false;
    }
}
