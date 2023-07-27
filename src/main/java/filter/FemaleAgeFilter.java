package filter;

import java.util.Map;
import java.util.function.Predicate;
import model.Person;

public class FemaleAgeFilter implements Predicate<Map<String, Object>> {
    private static final String FROM_AGE_KEY = "fromAge";
    private static final String PERSON_KEY = "person";

    @Override
    public boolean test(Map<String, Object> personAndAges) {
        Person person = (Person) personAndAges.get(PERSON_KEY);
        int fromAge = (int) personAndAges.get(FROM_AGE_KEY);
        return person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= fromAge;
    }
}
