package predicate;

import java.util.function.Predicate;
import model.Person;

public class AgeAndSexPredicate implements Predicate<Person> {
    private final int fromAge;
    private final int femaleToAge;
    private final int maleToAge;

    public AgeAndSexPredicate(int fromAge, int femaleToAge, int maleToAge) {
        this.fromAge = fromAge;
        this.femaleToAge = femaleToAge;
        this.maleToAge = maleToAge;
    }

    @Override
    public boolean test(Person person) {
        int age = person.getAge();
        Person.Sex sex = person.getSex();
        if (age < fromAge) {
            return false;
        }
        if (sex == Person.Sex.WOMAN) {
            return age <= femaleToAge;
        } else if (sex == Person.Sex.MAN) {
            return age <= maleToAge;
        }
        return false;
    }
}
