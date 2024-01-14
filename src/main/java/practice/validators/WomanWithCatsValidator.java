package practice.validators;

import java.util.function.Predicate;
import model.Person;

public class WomanWithCatsValidator implements Predicate<Person> {
    private int femaleAge;

    public WomanWithCatsValidator(int femaleAge) {
        this.femaleAge = femaleAge;
    }

    @Override
    public boolean test(Person person) {
        return person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= femaleAge && !person.getCats().isEmpty();
    }
}
