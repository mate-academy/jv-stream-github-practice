package practice;

import java.util.function.Predicate;
import model.Person;

public class WorkablePeopleValidator implements Predicate<Person> {
    private int fromAge;
    private int femaleToAge;
    private int maleToAge;

    public WorkablePeopleValidator(int fromAge, int femaleToAge, int maleToAge) {
        this.fromAge = fromAge;
        this.femaleToAge = femaleToAge;
        this.maleToAge = maleToAge;
    }

    @Override
    public boolean test(Person human) {
        return human.getAge() >= fromAge
                && (human.getSex() == Person.Sex.MAN
                ? human.getAge() <= maleToAge
                : human.getAge() <= femaleToAge);
    }
}
