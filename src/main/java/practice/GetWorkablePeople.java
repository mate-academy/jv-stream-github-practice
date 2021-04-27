package practice;

import java.util.function.Predicate;
import model.People;

public class GetWorkablePeople implements Predicate<People> {
    private final int fromAge;
    private final int maleToAge;
    private final int femaleToAge;

    public GetWorkablePeople(int fromAge, int maleToAge, int femaleToAge) {
        this.fromAge = fromAge;
        this.maleToAge = maleToAge;
        this.femaleToAge = femaleToAge;
    }

    @Override
    public boolean test(People people) {
        return people.getSex() == People.Sex.MAN
                ? people.getAge() >= fromAge && people.getAge() <= maleToAge
                : people.getAge() >= fromAge && people.getAge() <= femaleToAge;
    }
}
