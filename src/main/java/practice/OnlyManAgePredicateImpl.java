package practice;

import model.Person;

public class OnlyManAgePredicateImpl implements OnlyManAgePredicate<Person, Integer> {
    @Override
    public boolean test(Person person, Integer fromAge, Integer toAge) {
        return person.getAge() >= fromAge
                && person.getAge() <= toAge
                && person.getSex() == Person.Sex.MAN;
    }
}
