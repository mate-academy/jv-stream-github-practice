package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REGEX = "-";
    private static final String UKRAINIAN = "Ukrainian";
    private static final int MINIMAL_AGE = 35;
    private static final int MINIMUM_YEARS_IN_UKRAINE = 10;
    private static final int LIVES_IN_UKRAINE_FROM_INDEX = 0;
    private static final int LIVES_IN_UKRAINE_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals(UKRAINIAN)
                && candidate.getAge() >= MINIMAL_AGE
                && candidate.isAllowedToVote()
                && calculatePeriodInUkraine(
                        candidate.getPeriodsInUkr()) >= MINIMUM_YEARS_IN_UKRAINE;
    }

    private int calculatePeriodInUkraine(String period) {
        String[] periodInUkraine = period.split(REGEX);
        return Integer.parseInt(periodInUkraine[LIVES_IN_UKRAINE_TO_INDEX])
                - Integer.parseInt(periodInUkraine[LIVES_IN_UKRAINE_FROM_INDEX]);
    }
}
