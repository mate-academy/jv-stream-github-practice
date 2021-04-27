package practice;

import java.util.function.Predicate;
import model.People;

public class MenSelector implements Predicate<People> {
    private final int fromAge;
    private final int toAge;

    public MenSelector(int fromAge, int toAge) {
        this.fromAge = fromAge;
        this.toAge = toAge;
    }

    @Override
    public boolean test(People people) {
        return people.getAge() >= fromAge
                && people.getAge() <= toAge
                && people.getSex() == People.Sex.MAN;
    }
}
