package practice.util;

import java.util.function.Predicate;
import model.Person;

public class AgeRangePredicate implements Predicate<Person> {
    private final int fromAge;
    private final int femaleToAge;
    private final int maleToAge;

    public AgeRangePredicate(int fromAge, int femaleToAge, int maleToAge) {
        this.fromAge = fromAge;
        this.femaleToAge = femaleToAge;
        this.maleToAge = maleToAge;
    }

    @Override
    public boolean test(Person person) {
        int age = person.getAge();
        Person.Sex sex = person.getSex();

        return sex == Person.Sex.WOMAN && age >= fromAge && age <= femaleToAge
                || sex == Person.Sex.MAN && age >= fromAge && age <= maleToAge;
    }
}
