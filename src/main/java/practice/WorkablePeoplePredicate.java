package practice;

import java.util.function.Predicate;
import model.Person;

public class WorkablePeoplePredicate implements Predicate<Person> {
    private final int fromAge;
    private final int femaleToAge;
    private final int maleToAge;

    public WorkablePeoplePredicate(int fromAge, int femaleToAge, int maleToAge) {
        this.fromAge = fromAge;
        this.femaleToAge = femaleToAge;
        this.maleToAge = maleToAge;
    }

    @Override
    public boolean test(Person person) {
        if (person.getSex() == Person.Sex.MAN) {
            return person.getAge() >= fromAge && person.getAge() <= maleToAge;
        }
        return person.getAge() >= fromAge && person.getAge() <= femaleToAge;
    }
}
