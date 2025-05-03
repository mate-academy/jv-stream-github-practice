package practice.validators;

import java.util.function.Predicate;
import model.Person;

public class WorkablePersonValidator implements Predicate<Person> {
    private int fromAge;
    private int femaleAge;
    private int maleToAge;

    public WorkablePersonValidator(int fromAge, int femaleAge, int maleToAge) {
        this.fromAge = fromAge;
        this.femaleAge = femaleAge;
        this.maleToAge = maleToAge;
    }

    @Override
    public boolean test(Person person) {
        int age = person.getAge();
        if (person.getSex() == Person.Sex.MAN) {
            return age >= fromAge && age <= maleToAge;
        }
        return age >= fromAge && age <= femaleAge;

    }
}
