package practice;

import model.Person;

public class PeopleAgePredicateImpl implements PeopleAgePredicate<Integer, Person> {
    @Override
    public boolean test(Integer fromAge, Integer femaleToAge,
                        Integer maleToAge, Person person) {
        return person.getAge() >= fromAge
                && (person.getAge() <= femaleToAge && person.getSex() == Person.Sex.WOMAN
                || person.getAge() <= maleToAge && person.getSex() == Person.Sex.MAN);
    }
}
