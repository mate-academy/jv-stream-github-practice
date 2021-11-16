package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String YEAR_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getIntPeriod(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_UKRAINE;
    }

    private int getIntPeriod(String period) {
        int periodFrom = Integer.parseInt(period.substring(0, period.indexOf(YEAR_SEPARATOR)));
        int periodTo = Integer.parseInt(period.substring(period.indexOf(YEAR_SEPARATOR) + 1));
        return periodTo - periodFrom;
    }
}
