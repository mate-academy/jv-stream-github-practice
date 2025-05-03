package practice.custompredicates;

import java.util.function.Predicate;
import model.Person;

public class WorkablePeoplePredicate implements Predicate<Person> {
    private int fromAge;
    private int femaleToAge;
    private int maleToAge;

    public WorkablePeoplePredicate(int fromAge, int femaleToAge, int maleToAge) {
        this.fromAge = fromAge;
        this.femaleToAge = femaleToAge;
        this.maleToAge = maleToAge;
    }

    @Override
    public boolean test(Person person) {
        if (person.getAge() >= fromAge) {
            return person.getSex() == Person.Sex.MAN
                    ? person.getAge() <= maleToAge : person.getAge() <= femaleToAge;
        }
        return false;
    }
}
