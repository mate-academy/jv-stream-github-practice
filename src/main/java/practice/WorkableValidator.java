package practice;

import java.util.function.Predicate;
import model.Person;

public class WorkableValidator implements Predicate<Person> {
    private final int fromAge;
    private final int femaleToAge;
    private final int maleToAge;

    public WorkableValidator(int fromAge, int femaleToAge, int maleToAge) {
        this.fromAge = fromAge;
        this.femaleToAge = femaleToAge;
        this.maleToAge = maleToAge;
    }

    @Override
    public boolean test(Person person) {
        int age = person.getAge();
        Person.Sex sex = person.getSex();
        return age >= fromAge
                && ((sex == Person.Sex.MAN && age <= maleToAge)
                || (sex == Person.Sex.WOMAN && age <= femaleToAge));
    }
}
