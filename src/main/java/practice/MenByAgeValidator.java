package practice;

import interfaces.MenByAgePredicate;
import model.Person;

public class MenByAgeValidator implements MenByAgePredicate<Person, Integer, Integer> {

    @Override
    public boolean validate(Person person, Integer fromAge, Integer toAge) {
        return person.getSex().equals(Person.Sex.MAN)
                && person.getAge() >= fromAge && person.getAge() <= toAge;
    }
}
