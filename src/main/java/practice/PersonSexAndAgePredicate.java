package practice;

import java.util.function.Predicate;
import model.Person;

public class PersonSexAndAgePredicate implements Predicate<Person> {
    private final Person.Sex sex;
    private final int fromAge;
    private final int toAge;

    public PersonSexAndAgePredicate(Person.Sex sex, int fromAge, int toAge) {
        this.sex = sex;
        this.fromAge = fromAge;
        this.toAge = toAge;
    }

    @Override
    public boolean test(Person person) {
        return person.getSex() == sex
                && person.getAge() >= fromAge
                && person.getAge() <= toAge;
    }
}
