package practice;

import model.Person;

public class OnlyManAgePredicateImpl implements OnlyManAgePredicate<Person, Integer> {
    @Override
    public boolean test(Person person, Integer fromAge, Integer toAge) {
        int age = person.getAge();

        return age >= fromAge
                && age <= toAge
                && person.getSex() == Person.Sex.MAN;
    }
}
