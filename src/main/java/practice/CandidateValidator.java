package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_OF_RESIDENCE_IN_UKR = 10;
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && getCountOfYearsInTheCountry(candidate)
                >= MIN_YEARS_OF_RESIDENCE_IN_UKR;
    }

    private int getCountOfYearsInTheCountry(Candidate candidate) {
        int[] firstAndLastYears = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return firstAndLastYears[YEAR_TO_INDEX] - firstAndLastYears[YEAR_FROM_INDEX];
    }
}
