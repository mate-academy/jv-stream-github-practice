package practice;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_LIVE_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String STRING_REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        IntSummaryStatistics range = Arrays.stream(candidate.getPeriodsInUkr().split(STRING_REGEX))
                .mapToInt(Integer::parseInt)
                .summaryStatistics();
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && range.getMax() - range.getMin() >= MIN_LIVE_IN_UKRAINE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote();
    }
}
