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
        if (person.getSex() != Person.Sex.MAN) {
            return false;
        }
        int age = person.getAge();
        if (age < fromAge || age > toAge) {
            return false;
        }
        return true;
    }
}
