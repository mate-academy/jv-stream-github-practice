package practice;

import java.util.function.Predicate;
import model.Person;

public class WorkablePeopleValidator implements Predicate<Person> {
    private final int fromAge;
    private final int femaleToAge;
    private final int maleToAge;

    public WorkablePeopleValidator(int fromAge, int femaleToAge, int maleToAge) {
        this.fromAge = fromAge;
        this.femaleToAge = femaleToAge;
        this.maleToAge = maleToAge;
    }

    @Override
    public boolean test(Person person) {
        return person.getAge() >= fromAge
                && ((Person.Sex.MAN == person.getSex() && person.getAge() <= maleToAge)
                || (Person.Sex.WOMAN == person.getSex() && person.getAge() <= femaleToAge));
    }
}
