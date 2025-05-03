package practice;

import java.util.function.Predicate;
import model.Person;

public class AgePredicate implements Predicate<Person> {
    private final int fromAge;
    private final int toAge;

    public AgePredicate(int fromAge, int toAge) {
        this.fromAge = fromAge;
        this.toAge = toAge;
    }

    @Override
    public boolean test(Person person) {
        return person.getAge() >= fromAge && person.getAge() <= toAge;
    }
}
