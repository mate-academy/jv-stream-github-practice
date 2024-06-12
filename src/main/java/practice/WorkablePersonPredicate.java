package practice;

import java.util.function.Predicate;
import model.Person;
import model.Person.Sex;

public class WorkablePersonPredicate implements Predicate<Person> {
    private final int fromAge;
    private final int femaleToAge;
    private final int maleToAge;

    public WorkablePersonPredicate(int fromAge, int femaleToAge, int maleToAge) {
        this.fromAge = fromAge;
        this.femaleToAge = femaleToAge;
        this.maleToAge = maleToAge;
    }

    @Override
    public boolean test(Person person) {
        int age = person.getAge();
        Sex sex = person.getSex();
        return age >= fromAge
                && ((sex == Sex.MAN && age <= maleToAge)
                || (sex == Sex.WOMAN && age <= femaleToAge));
    }
}
