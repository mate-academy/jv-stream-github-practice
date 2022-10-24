package practice.custompredicates;

import java.util.function.Predicate;
import model.Person;

public class CatOwnersPredicate implements Predicate<Person> {
    private int femaleAge;

    public CatOwnersPredicate(int femaleAge) {
        this.femaleAge = femaleAge;
    }

    @Override
    public boolean test(Person person) {
        return person.getSex() == Person.Sex.WOMAN && person.getAge() >= femaleAge;
    }
}
