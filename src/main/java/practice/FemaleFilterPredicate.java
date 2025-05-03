package practice;

import java.util.function.Predicate;
import model.Person;

public class FemaleFilterPredicate implements Predicate<Person> {
    private final int femaleAge;

    public FemaleFilterPredicate(int femaleAge) {
        this.femaleAge = femaleAge;
    }

    @Override
    public boolean test(Person person) {
        return person.getSex().equals(Person.Sex.WOMAN) && person.getAge() >= femaleAge;
    }
}
