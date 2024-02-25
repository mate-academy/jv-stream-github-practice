package practice;

import java.util.function.Predicate;
import model.Person;

class PersonFilter implements Predicate<Person> {
    private final int fromAge;
    private final int maleToAge;
    private final int femaleToAge;

    PersonFilter(int fromAge, int maleToAge, int femaleToAge) {
        this.fromAge = fromAge;
        this.maleToAge = maleToAge;
        this.femaleToAge = femaleToAge;
    }

    @Override
    public boolean test(Person person) {
        if (person.getSex() == Person.Sex.WOMAN) {
            return person.getAge() >= fromAge && person.getAge() <= femaleToAge;
        } else if (person.getSex() == Person.Sex.MAN) {
            return person.getAge() >= fromAge && person.getAge() <= maleToAge;
        }
        return false;
    }
}
