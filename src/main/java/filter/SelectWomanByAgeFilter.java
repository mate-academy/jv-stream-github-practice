package filter;

import java.util.Map;
import java.util.function.Predicate;
import model.Person;

public class SelectWomanByAgeFilter implements Predicate<Map<String, Object>> {
    @Override
    public boolean test(Map<String, Object> stringObjectMap) {
        Person person = (Person) stringObjectMap.get("person");
        Integer femaleAge = (Integer) stringObjectMap.get("femaleAge");
        return person.getSex().equals(Person.Sex.WOMAN) && person.getAge() >= femaleAge;
    }
}
