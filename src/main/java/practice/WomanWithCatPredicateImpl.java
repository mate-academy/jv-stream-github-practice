package practice;

import model.Person;

public class WomanWithCatPredicateImpl implements WomanWithCatPredicate<Person, Integer> {
    @Override
    public boolean test(Person person, Integer femaleAge) {
        return person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= femaleAge;
    }
}
