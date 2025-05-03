package practice;

import java.util.function.Predicate;
import model.Person;

public class WorkablePeopleValidator implements Predicate<Person> {
    private int fromAge;
    private int femaleToAge;
    private int maleToAge;

    public WorkablePeopleValidator(int fromAge, int femaleToAge, int maleToAge) {
        this.fromAge = fromAge;
        this.femaleToAge = femaleToAge;
        this.maleToAge = maleToAge;
    }

    @Override
    public boolean test(Person person) {
        return person.getSex() == Person.Sex.MAN && person.getAge() >= fromAge
                && person.getAge() <= maleToAge
                || person.getSex() == Person.Sex.WOMAN && person.getAge() >= fromAge
                && person.getAge() <= femaleToAge;
    }
}
