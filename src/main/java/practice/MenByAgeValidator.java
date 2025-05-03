package practice;

import java.util.function.Predicate;
import model.Person;

public class MenByAgeValidator implements Predicate<Person> {
    private int fromAge;
    private int toAge;

    public MenByAgeValidator(int fromAge, int toAge) {
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
