package filter;

import java.util.Map;
import java.util.function.Predicate;
import model.Person;

public class WorkableAgeFilter implements Predicate<Map<String, Object>> {
    private static final String FROM_AGE_KEY = "fromAge";
    private static final String MALE_TO_AGE_KEY = "maleToAge";
    private static final String FEMALE_TO_AGE_KEY = "femaleToAge";
    private static final String PERSON_KEY = "person";

    @Override
    public boolean test(Map<String, Object> personAndAges) {
        Person person = (Person) personAndAges.get(PERSON_KEY);
        int personAge = person.getAge();
        int fromAge = (int) personAndAges.get(FROM_AGE_KEY);
        int maleToAge = (int) personAndAges.get(MALE_TO_AGE_KEY);
        int femaleToAge = (int) personAndAges.get(FEMALE_TO_AGE_KEY);
        return personAge >= fromAge
                && (person.getSex() == Person.Sex.MAN ? personAge <= maleToAge
                : personAge <= femaleToAge);
    }
}
