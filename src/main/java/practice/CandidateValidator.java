package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_ELIGIBLE_AGE = 35;
    private static final int MIN_PERIOD_IN_COUNTRY = 10;
    private static final int PERIOD_START_YEAR_INDEX = 0;
    private static final int PERIOD_END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        int[] periodsInUkr = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                                .mapToInt(Integer::parseInt)
                                .toArray();
        return candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && candidate.getAge() >= MIN_ELIGIBLE_AGE
                && periodsInUkr[PERIOD_END_YEAR_INDEX]
                    - periodsInUkr[PERIOD_START_YEAR_INDEX]
                    >= MIN_PERIOD_IN_COUNTRY;
    }
}
