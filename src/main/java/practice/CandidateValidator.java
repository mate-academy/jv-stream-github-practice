package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int BOUND_YEAR = 10;
    private static final int START_POSITION = 0;
    private static final int SEPARATOR_POSITION = 4;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals(NATIONALITY)
                && (candidate.isAllowedToVote()) && candidate.getAge() >= MINIMUM_AGE
                && getUkrainianPeriod(candidate.getPeriodsInUkr()) > BOUND_YEAR;
    }

    private int getUkrainianPeriod(String periodInUkr) {
        if (periodInUkr == null || periodInUkr.isEmpty()) {
            throw new RuntimeException("Unappropriate period");
        }
        int start = Integer.parseInt(periodInUkr.substring(START_POSITION, SEPARATOR_POSITION));
        int end = Integer.parseInt(periodInUkr.substring(SEPARATOR_POSITION + 1));
        return end - start;
    }
}
