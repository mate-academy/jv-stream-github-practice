package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;
    private static final String EXPECTED_NATIONALITY = "Ukrainian";
    private static final int DATE_FROM_INDEX = 0;
    private static final int DATE_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(dates[DATE_TO_INDEX])
                - Integer.parseInt(dates[DATE_FROM_INDEX]);
        return candidate.getAge() >= MIN_AGE
            && candidate.getNationality().equals(EXPECTED_NATIONALITY)
            && period >= MIN_PERIOD
                && candidate.isAllowedToVote();
    }
}
