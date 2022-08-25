package practice;

import java.util.function.Predicate;
import model.Person;

public class PredicateGetCatsNames implements Predicate<Person> {
    private int femaleAge;

    public PredicateGetCatsNames(int femaleAge) {
        this.femaleAge = femaleAge;
    }

    @Override
    public boolean test(Person person) {
        return person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= femaleAge
                && !person.getCats().isEmpty();
    }
}
