package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_TO_LIVE_IN_UKRAINE = 10;
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int fromYear = Integer.parseInt(period[YEAR_FROM_INDEX]);
        int toYear = Integer.parseInt(period[YEAR_TO_INDEX]);
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && toYear - fromYear >= MIN_YEARS_TO_LIVE_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}
