package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final int REQUIRED_PERIOD_IN_UKRAINE = 10;
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;
    private static final String PERIOD_REGEX = "-";
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(PERIOD_REGEX);
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && Integer.parseInt(years[YEAR_TO_INDEX])
                - Integer.parseInt(years[YEAR_FROM_INDEX])
                >= REQUIRED_PERIOD_IN_UKRAINE;
    }
}
