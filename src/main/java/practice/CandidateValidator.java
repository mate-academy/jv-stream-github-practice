package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SEPARATE = "-";
    private static final String NATIONALITY = "Ukrainian";
    private static final int YEAR_TO = 1;
    private static final int YEAR_FROM = 0;
    private static final int VALID_AGE = 35;
    private static final int VALID_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearFromTo = candidate.getPeriodsInUkr().split(SEPARATE);
        int period = Integer.parseInt(yearFromTo[YEAR_TO])
                - Integer.parseInt(yearFromTo[YEAR_FROM]);

        return candidate.getAge() >= VALID_AGE && candidate.getNationality().equals(NATIONALITY)
                && period >= VALID_PERIOD && candidate.isAllowedToVote();
    }
}
