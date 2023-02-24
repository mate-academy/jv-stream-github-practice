package practice;

import java.util.function.Predicate;
import model.Person;

public class PersonFilter implements Predicate<Person> {
    private static final int DEFAULT_MAX_AGE = 120;
    private final int ageFrom;
    private final Person.Sex sex;
    private int ageTo;

    public PersonFilter(int ageFrom, Person.Sex sex) {
        this.ageFrom = ageFrom;
        this.sex = sex;
    }

    public PersonFilter(int ageFrom, int ageTo, Person.Sex sex) {
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        this.sex = sex;
    }

    @Override
    public boolean test(Person person) {
        ageTo = ageTo == 0 ? DEFAULT_MAX_AGE : ageTo;
        return person.getAge() >= ageFrom
                && person.getAge() <= ageTo
                && person.getSex() == sex;
    }
}
