package practice;

import java.util.function.Predicate;
import model.Person;

public class WorkablePeopleValidator implements Predicate<Person> {
    /**
     * Evaluates this predicate on the given argument.
     *
     * @param person the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
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
        return person.getAge() >= fromAge
                && ((person.getSex() == Person.Sex.MAN && person.getAge() <= maleToAge)
                || (person.getSex() == Person.Sex.WOMAN && person.getAge() <= femaleToAge));
    }
}
