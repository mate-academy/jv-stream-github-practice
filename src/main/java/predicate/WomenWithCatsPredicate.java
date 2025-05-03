package predicate;

import java.util.function.Predicate;
import model.Person;

public class WomenWithCatsPredicate implements Predicate<Person> {
    private final int femaleAge;

    public WomenWithCatsPredicate(int femaleAge) {
        this.femaleAge = femaleAge;
    }

    @Override
    public boolean test(Person person) {
        return person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= femaleAge
                && person.getCats() != null;
    }
}
