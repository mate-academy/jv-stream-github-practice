package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String PERIODS_DELIMITER = "-";
    private static final int START_OF_PERIOD_INDEX = 0;
    private static final int END_OF_PERIOD_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && Objects.equals(candidate.getNationality(), NATIONALITY)
                && hasLivedInUkraineForTenYears(candidate);
    }

    private boolean hasLivedInUkraineForTenYears(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split(PERIODS_DELIMITER);
        return Integer.parseInt(split[END_OF_PERIOD_INDEX])
                - Integer.parseInt(split[START_OF_PERIOD_INDEX])
                >= MIN_PERIOD_IN_UKRAINE;
    }
}
