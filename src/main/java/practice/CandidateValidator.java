package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ALLOWED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_OF_LIVING = 10;
    private static final String PERIOD_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        int periodOfLiving = Arrays.stream(candidate.getPeriodsInUkr()
                .split(PERIOD_SEPARATOR))
                .mapToInt(Integer::parseInt)
                .reduce((year1, year2) -> year2 - year1)
                .getAsInt();
        return candidate.getAge() >= MIN_ALLOWED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && periodOfLiving >= MIN_PERIOD_OF_LIVING;
    }
}
