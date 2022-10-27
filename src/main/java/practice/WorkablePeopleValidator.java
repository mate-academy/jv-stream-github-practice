package practice;

import java.util.function.Predicate;
import model.Person;

public class WorkablePeopleValidator implements Predicate<Person> {
    private final int fromAge;
    private final int maleToAge;
    private final int femaleToAge;

    public WorkablePeopleValidator(int fromAge, int maleToAge, int femaleToAge) {
        this.fromAge = fromAge;
        this.maleToAge = maleToAge;
        this.femaleToAge = femaleToAge;
    }

    @Override
    public boolean test(Person person) {
        int age = person.getAge();
        Person.Sex sex = person.getSex();
        return (sex == Person.Sex.MAN
                && age <= maleToAge
                || sex == Person.Sex.WOMAN
                && age <= femaleToAge)
                && age >= fromAge;
    }
}
