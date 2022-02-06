package practice;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_MIN_AGE = 35;
    private static final int CANDIDATE_MIN_LIVING_IN_UKRAINE = 10;
    private static final String CANDIDATE_DEMAND_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        final IntSummaryStatistics intSummaryStatistics = Arrays.stream(candidate.getPeriodsInUkr()
                        .split("-"))
                .mapToInt(Integer::parseInt).summaryStatistics();
        final boolean validPeriod = (intSummaryStatistics.getMax() - intSummaryStatistics.getMin())
                >= CANDIDATE_MIN_LIVING_IN_UKRAINE;
        return candidate.getAge() >= CANDIDATE_MIN_AGE
                && candidate.getNationality().equals(CANDIDATE_DEMAND_NATIONALITY)
                && candidate.isAllowedToVote()
                && validPeriod;
    }
}
