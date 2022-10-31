package practice;

import java.util.function.Predicate;
import model.Person;

public class WorkablePeopleIdentifier implements Predicate<Person> {
    private final int fromAge;
    private final int femaleToAge;
    private final int maleToAge;

    public WorkablePeopleIdentifier(int fromAge, int femaleToAge, int maleToAge) {
        this.fromAge = fromAge;
        this.femaleToAge = femaleToAge;
        this.maleToAge = maleToAge;
    }

    @Override
    public boolean test(Person person) {
        return person.getAge() >= fromAge
                && ((person.getSex().equals(Person.Sex.MAN) && person.getAge() <= maleToAge)
                || (person.getSex().equals(Person.Sex.WOMAN) && person.getAge() <= femaleToAge));
    }
}
