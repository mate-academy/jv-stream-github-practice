package practice;

import java.util.function.Predicate;
import model.Person;

public class SelectMenByAgeValidator implements Predicate<Person> {
    private final int fromAge;
    private final int toAge;

    public SelectMenByAgeValidator(int fromAge, int toAge) {
        this.fromAge = fromAge;
        this.toAge = toAge;
    }

    @Override
    public boolean test(Person person) {
        int age = person.getAge();
        Person.Sex sex = person.getSex();
        return age >= fromAge && age <= toAge && sex == Person.Sex.MAN;
    }
}
