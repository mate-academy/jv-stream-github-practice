package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ALLOWED_AGE = 35;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UA = 10;
    private static final String YEARS_SEPARATOR = "-";
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    private int getYearsInUaOfCandidate(String periodInUkraine) {
        int[] years = Arrays.stream(periodInUkraine.split(YEARS_SEPARATOR))
                .mapToInt(Integer::parseInt)
                .toArray();
        return years[END_YEAR_INDEX] - years[START_YEAR_INDEX];
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_ALLOWED_AGE
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && getYearsInUaOfCandidate(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_UA;
    }
}
