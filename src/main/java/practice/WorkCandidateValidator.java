package practice;

import java.util.function.Predicate;
import model.Person;

public class WorkCandidateValidator implements Predicate<Person> {
    private final int fromAge;
    private final int femaleToAge;
    private final int maleToAge;

    public WorkCandidateValidator(int fromAge, int femaleToAge, int maleToAge) {
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
