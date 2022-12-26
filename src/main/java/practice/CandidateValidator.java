package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String REQUIRED_NATIONALITY = "Ukrainian";
    public static final int YEAR_TO_INDEX = 1;
    public static final int YEAR_FROM_INDEX = 0;
    public static final int REQUIRED_MIN_PERIOD = 10;
    public static final int REQUIRED_MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.getAge() >= REQUIRED_MIN_AGE
                && countPeriodInUkraine(candidate) >= REQUIRED_MIN_PERIOD;
    }

    private static int countPeriodInUkraine(Candidate candidate) {
        return Integer.parseInt(candidate
                .getPeriodsInUkr()
                .split("-")[YEAR_TO_INDEX])
                - Integer.parseInt(candidate
                .getPeriodsInUkr()
                .split("-")[YEAR_FROM_INDEX]);
    }
}
