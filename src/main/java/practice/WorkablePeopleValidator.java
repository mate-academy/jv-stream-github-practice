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
    public boolean test(Person person) {
        int age = person.getAge();
        Person.Sex sex = person.getSex();
        if (age < fromAge) {
            return false;
        }
        return (sex == Person.Sex.MAN && age <= maleToAge)
                || (sex == Person.Sex.WOMAN && age <= femaleToAge);
    }
}
