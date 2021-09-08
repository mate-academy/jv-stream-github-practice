package practice;

import interfaces.WomenByAgePredicate;
import model.Person;

public class WomenByAgeValidator implements WomenByAgePredicate<Person, Integer> {

    @Override
    public boolean validate(Person person, Integer fromAge) {
        return person.getSex().equals(Person.Sex.WOMAN)
                && person.getAge() >= fromAge
                && !person.getCats().isEmpty();
    }
}
