package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_PRESIDENT = 35;
    private static final int PERIOD_IN_UKRAINE_FROM = 0;
    private static final int PERIOD_IN_UKRAINE_TO = 1;
    private static final int MIN_LIMIT_OF_YEARS = 10;
    private static final String DELIMITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        int[] periodInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .toArray();
        return candidate.getAge() >= MIN_AGE_FOR_PRESIDENT
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodInUkraine[PERIOD_IN_UKRAINE_TO] - periodInUkraine[PERIOD_IN_UKRAINE_FROM]
                >= MIN_LIMIT_OF_YEARS;
    }
}
