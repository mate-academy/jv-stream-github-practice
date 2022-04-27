package practice;

import java.util.function.Predicate;
import model.Person;

public class PersonValidator implements Predicate<Person> {
    private int fromAge;
    private int femaleToAge;
    private int maleToAge;

    public PersonValidator(int fromAge, int femaleToAge, int maleToAge) {
        this.fromAge = fromAge;
        this.femaleToAge = femaleToAge;
        this.maleToAge = maleToAge;
    }

    @Override
    public boolean test(Person person) {
        return person.getAge() >= fromAge
                && (person.getSex() == Person.Sex.WOMAN
                && person.getAge() <= femaleToAge
                || person.getSex() == Person.Sex.MAN
                && person.getAge() <= maleToAge);
    }
}
