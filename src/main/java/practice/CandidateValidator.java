package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEAR_LIVING = 10;
    private static final int INDEX_STAT_YEAR = 0;
    private static final int INDEX_END_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && isLongTimePeriod(candidate.getPeriodsInUkr());
    }

    private boolean isLongTimePeriod(String prePeriod) {
        String[] periodInUkr = prePeriod.split("-");
        int countYearInUkr = Integer.parseInt(periodInUkr[INDEX_END_YEAR])
                - Integer.parseInt(periodInUkr[INDEX_STAT_YEAR]);
        return countYearInUkr >= MIN_YEAR_LIVING;
    }
}
