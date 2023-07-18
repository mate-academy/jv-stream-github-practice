package filter;

import java.util.Map;
import java.util.function.Predicate;
import model.Person;

public class SelectMenByAgeFilter implements Predicate<Map<String, Object>> {
    @Override
    public boolean test(Map<String, Object> stringObjectMap) {
        Person person = (Person) stringObjectMap.get("person");
        int fromAge = (int) stringObjectMap.get("fromAge");
        int toAge = (int) stringObjectMap.get("toAge");
        return person.getSex().equals(Person.Sex.MAN) && person.getAge() >= fromAge
                && person.getAge() <= toAge;
    }
}
