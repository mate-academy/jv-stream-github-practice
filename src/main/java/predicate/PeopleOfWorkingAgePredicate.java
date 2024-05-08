package predicate;

import java.util.function.Predicate;
import model.Person;

public class PeopleOfWorkingAgePredicate implements Predicate<Person> {
    private final int fromAge;
    private final int femaleToAge;
    private final int maleToAge;

    public PeopleOfWorkingAgePredicate(int fromAge, int femaleToAge, int maleToAge) {
        this.fromAge = fromAge;
        this.femaleToAge = femaleToAge;
        this.maleToAge = maleToAge;
    }

    @Override
    public boolean test(Person person) {
        if (person.getAge() < fromAge) {
            return false;
        }
        if (person.getSex() == Person.Sex.MAN) {
            return person.getAge() <= maleToAge;
        } else {
            return person.getAge() <= femaleToAge;
        }
    }
}
