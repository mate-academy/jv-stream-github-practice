package practice;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality())
                && checkPeriod(candidate.getPeriodsInUkr());
    }

    private boolean checkPeriod(String period) {
        IntSummaryStatistics statistics = Arrays.stream(period.split(SEPARATOR))
                .mapToInt(Integer::valueOf)
                .summaryStatistics();
        return statistics.getMax() - statistics.getMin() >= MIN_PERIOD;
    }
}
