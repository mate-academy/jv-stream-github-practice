package practice;

import java.util.function.Predicate;
import model.Person;

public class SexPredicate implements Predicate<Person> {
    private final Person.Sex sex;

    public SexPredicate(Person.Sex sex) {
        this.sex = sex;
    }

    @Override
    public boolean test(Person person) {
        return person.getSex().equals(sex);
    }
}
