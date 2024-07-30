package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIODS = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && calculatePeriods(candidate.getPeriodsInUkr());
    }

    private boolean calculatePeriods(String periods) {
        String[] year = periods.split("-");
        return Integer.parseInt(year[1]) - Integer.parseInt(year[0]) >= MIN_PERIODS;
    }
}
