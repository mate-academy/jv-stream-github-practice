package filter;

import java.util.Map;
import java.util.function.Predicate;
import model.Person;

public class GetWorkablePeopleFilter implements Predicate<Map<String, Object>> {
    @Override
    public boolean test(Map<String, Object> stringObjectMap) {
        Person person = (Person) stringObjectMap.get("person");
        int fromAge = (int) stringObjectMap.get("fromAge");
        int maleToAge = (int) stringObjectMap.get("maleToAge");
        int femaleToAge = (int) stringObjectMap.get("femaleToAge");
        return person.getSex().equals(Person.Sex.MAN)
                && person.getAge() >= fromAge && person.getAge() <= maleToAge
                || person.getSex().equals(Person.Sex.WOMAN) && person.getAge() >= fromAge
                && person.getAge() <= femaleToAge;
    }
}
