package practice;

import static java.lang.Integer.parseInt;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int MINIMUM_AGE = 35;
    private static final int START_YEAR = 0;
    private static final int END_YEAR = 1;

    @Override
    public boolean test(Candidate person) {
        String time = person.getPeriodsInUkr();
        String[] split = time.split("-");
        boolean actual = parseInt(split[END_YEAR])
                - parseInt(split[START_YEAR]) >= MIN_PERIOD_IN_UKRAINE;
        return (person.getAge() >= MINIMUM_AGE
                && person.getNationality().equals(VALID_NATIONALITY)
                && actual && person.isAllowedToVote());
    }
}
