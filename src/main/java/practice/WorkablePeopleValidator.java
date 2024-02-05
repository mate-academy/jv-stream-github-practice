package practice;

import java.util.function.Predicate;
import model.Person;

public class WorkablePeopleValidator implements Predicate<Person> {
    private final int fromAge;
    private final int femaleToAge;
    private final int maleToAge;

    public WorkablePeopleValidator(int fromAge, int femaleToAge, int maleToAge) {
        this.fromAge = fromAge;
        this.femaleToAge = femaleToAge;
        this.maleToAge = maleToAge;
    }

    @Override
    public boolean test(Person p) {
        return p.getAge() >= fromAge
                && ((p.getAge() <= maleToAge
                        && p.getSex().equals(Person.Sex.MAN))
                        || (p.getSex().equals(Person.Sex.WOMAN)
                        && p.getAge() >= fromAge
                        && p.getAge() <= femaleToAge));
    }
}
