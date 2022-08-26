package practice;

import java.util.function.Predicate;
import model.Person;

public class CatOwnersFilter implements Predicate<Person> {
    private int femaleAge;

    public CatOwnersFilter(int femaleAge) {
        this.femaleAge = femaleAge;
    }

    @Override
    public boolean test(Person person) {
        return person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= femaleAge
                && !person.getCats().isEmpty();
    }
}
