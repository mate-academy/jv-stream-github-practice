package practice;

import java.util.function.Predicate;
import model.Person;

public class WorkablePeopleValidator implements Predicate<Person> {
    private final int minAge;
    private final int maleToAge;
    private final int femaleToAge;

    public WorkablePeopleValidator(int minAge, int maleToAge, int femaleToAge) {
        this.minAge = minAge;
        this.maleToAge = maleToAge;
        this.femaleToAge = femaleToAge;
    }

    public boolean test(Person person) {
        return person.getSex() == model.Person.Sex.MAN
                && person.getAge() >= minAge && person.getAge() <= maleToAge
                || person.getSex() == model.Person.Sex.WOMAN && person.getAge() >= minAge
                && person.getAge() <= femaleToAge;
    }
}
