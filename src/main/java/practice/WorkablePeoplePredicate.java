package practice;

import java.util.function.Predicate;
import model.Person;

public class WorkablePeoplePredicate implements Predicate<Person> {
    private int fromAge;
    private int maleToAge;
    private int femaleToAge;

    public WorkablePeoplePredicate(int fromAge, int maleToAge, int femaleToAge) {
        this.fromAge = fromAge;
        this.maleToAge = maleToAge;
        this.femaleToAge = femaleToAge;
    }

    @Override
    public boolean test(Person person) {
        if (person.getSex() == Person.Sex.MAN) {
            return person.getAge() >= fromAge && person.getAge() <= maleToAge;
        } else {
            return person.getAge() >= fromAge && person.getAge() <= femaleToAge;
        }
    }
}
