package practice;

import model.Person;

public class PeopleAgePredicateImpl implements PeopleAgePredicate<Integer, Person> {
    @Override
    public boolean test(Integer fromAge, Integer femaleToAge,
                        Integer maleToAge, Person person) {
        int age = person.getAge();
        Person.Sex sex = person.getSex();

        return age >= fromAge
                && (age <= femaleToAge && sex == Person.Sex.WOMAN
                || age <= maleToAge && sex == Person.Sex.MAN);
    }
}
