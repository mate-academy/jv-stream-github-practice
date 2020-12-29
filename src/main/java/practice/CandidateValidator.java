package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int START_POSITION = 0;
    private static final int SEPARATOR_POSITION = 4;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals("Ukrainian")
                && (candidate.isAllowedToVote()) && candidate.getAge() >= MINIMUM_AGE
                && ukrainianPeriod(candidate) > 10;
    }

    private int ukrainianPeriod(Candidate candidate) {
        if (candidate.getPeriodsInUkr() == null || candidate.getPeriodsInUkr().length() == 0) {
            throw new RuntimeException("Unappropriate period");
        }
        int start = Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(START_POSITION, SEPARATOR_POSITION));
        int end = Integer.parseInt(candidate.getPeriodsInUkr().substring(SEPARATOR_POSITION + 1));
        return end - start;
    }
}
