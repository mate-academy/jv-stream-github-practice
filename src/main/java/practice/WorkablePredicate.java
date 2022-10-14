package practice;

import java.util.function.Predicate;
import model.Person;

public class WorkablePredicate implements Predicate<Person> {
    private final int fromAge;
    private final int maleToAge;
    private final int femaleToAge;

    public WorkablePredicate(int fromAge, int maleToAge, int femaleToAge) {
        this.fromAge = fromAge;
        this.maleToAge = maleToAge;
        this.femaleToAge = femaleToAge;
    }

    @Override
    public boolean test(Person person) {
        return person.getAge() >= fromAge
                && person.getAge() <= (person.getSex() == Person.Sex.MAN
                ? maleToAge : femaleToAge);
    }
}
