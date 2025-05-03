package practice;

import java.util.function.Predicate;
import model.Person;

public class WorkablePredicate implements Predicate<Person> {
    private int fromAge;
    private int maleToAge;
    private int femaleToAge;

    public WorkablePredicate(int fromAge, int maleToAge, int femaleToAge) {
        this.fromAge = fromAge;
        this.maleToAge = maleToAge;
        this.femaleToAge = femaleToAge;
    }

    @Override
    public boolean test(Person person) {
        return ((person.getSex() == Person.Sex.MAN) && person.getAge() >= fromAge
                && person.getAge() <= maleToAge) || ((person.getSex() == Person.Sex.WOMAN)
                && person.getAge() >= fromAge && person.getAge() <= femaleToAge);
    }
}
