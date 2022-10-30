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
        return person.getAge() >= fromAge
                && ((Person.Sex.MAN == person.getSex() && person.getAge() <= maleToAge)
                || (Person.Sex.WOMAN == person.getSex() && person.getAge() <= femaleToAge));
    }
}
