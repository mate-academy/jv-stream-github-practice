package practice;

import java.util.function.Predicate;
import model.Person;

public class WorkablePeopleValidator implements Predicate<Person> {
    private final int fromAge;
    private final int maleToAge;
    private final int femaleToAge;

    public WorkablePeopleValidator(int fromAge, int maleToAge, int femaleToAge) {
        this.fromAge = fromAge;
        this.maleToAge = maleToAge;
        this.femaleToAge = femaleToAge;
    }

    @Override
    public boolean test(Person person) {
        boolean manAndFitsAge = person.getSex() == Person.Sex.MAN
                && person.getAge() >= fromAge && person.getAge() <= maleToAge;
        boolean womanAndFitsAge = person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= fromAge && person.getAge() <= femaleToAge;
        return manAndFitsAge || womanAndFitsAge;
    }
}
