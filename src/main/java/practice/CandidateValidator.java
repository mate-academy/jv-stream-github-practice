package practice;

import static java.lang.Integer.parseInt;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY_UKRAINIAN = "Ukrainian";
    private static final int TIME_LIVING_IN_UKRAINE = 10;
    private static final int MINIMUM_AGE = 35;
    private static final int START_YEAR = 0;
    private static final int END_YEAR = 1;

    @Override
    public boolean test(Candidate person) {
        String time = person.getPeriodsInUkr();
        String[] split = time.split("-");
        boolean actual = parseInt(split[END_YEAR])
                - parseInt(split[START_YEAR]) >= TIME_LIVING_IN_UKRAINE;
        return (person.getAge() >= MINIMUM_AGE
                && person.getNationality().equals(NATIONALITY_UKRAINIAN)
                && actual && person.isAllowedToVote());
    }
}
