package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UA = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getLifePeriod(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_UA;
    }

    private int getLifePeriod(String years) {
        return Arrays.stream(years.split(REGEX))
                .mapToInt(Integer::parseInt)
                .reduce((x,y) -> y - x)
                .getAsInt();
    }
}
