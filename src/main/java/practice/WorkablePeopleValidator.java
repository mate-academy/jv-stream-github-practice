package practice;

import interfaces.WorkablePeoplePredicate;
import model.Person;

public class WorkablePeopleValidator implements WorkablePeoplePredicate<Integer, Integer,
        Integer, Person> {
    @Override
    public boolean validate(Integer fromAge, Integer femaleToAge,
                            Integer maleToAge, Person person) {
        boolean isWoman = person.getSex().equals(Person.Sex.WOMAN);
        if (isWoman) {
            return person.getSex().equals(Person.Sex.WOMAN)
                    && person.getAge() >= fromAge && person.getAge() <= femaleToAge;
        }
        return person.getSex().equals(Person.Sex.MAN)
                && person.getAge() >= fromAge && person.getAge() <= maleToAge;
    }
}
