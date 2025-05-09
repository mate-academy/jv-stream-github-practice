package practice;

import java.util.function.Predicate;
import model.Person;

public class PersonValidator implements Predicate<Person> {
    private final int minAge;
    private final int maxMaleAge;
    private final int maxFemaleAge;

    public PersonValidator(int minAge, int maxMaleAge, int maxFemaleAge) {
        this.minAge = minAge;
        this.maxFemaleAge = maxFemaleAge;
        this.maxMaleAge = maxMaleAge;
    }

    @Override
    public boolean test(Person person) {
        int maxAge = person.getSex() == Person.Sex.WOMAN ? maxFemaleAge : maxMaleAge;
        return person.getAge() >= minAge
                && person.getAge() <= maxAge;
    }
}
