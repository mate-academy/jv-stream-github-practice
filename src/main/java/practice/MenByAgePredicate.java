package practice;

import java.util.function.Predicate;
import model.Person;

public class MenByAgePredicate implements Predicate<Person> {
    private final int fromAge;
    private final int toAge;

    public MenByAgePredicate(int fromAge, int toAge) {
        this.fromAge = fromAge;
        this.toAge = toAge;
    }

    @Override
    public boolean test(Person person) {
        return person.getSex() == Person.Sex.MAN
                && person.getAge() >= fromAge
                && person.getAge() <= toAge;
    }
}
