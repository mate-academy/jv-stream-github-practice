package practice;

import java.util.function.Predicate;
import model.Person;

public class PersonValidator implements Predicate<Person> {
    private final int fromAge;
    private final int femaleToAge;
    private final int maleToAge;

    public PersonValidator(int fromAge, int femaleToAge, int maleToAge) {
        this.fromAge = fromAge;
        this.femaleToAge = femaleToAge;
        this.maleToAge = maleToAge;
    }

    @Override
    public boolean test(Person person) {
        if (person == null) {
            return false;
        }

        return (person.getSex() == Person.Sex.MAN
                && person.getAge() >= fromAge && person.getAge() <= maleToAge)
                || (person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= fromAge && person.getAge() <= femaleToAge);
    }
}
