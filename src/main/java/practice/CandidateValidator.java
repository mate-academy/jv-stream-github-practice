package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_PERIOD_IN_UKRAINE = 10;
    private static final String DEFIES = "-";
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && getPeriodInUkraine(candidate.getPeriodsInUkr()) > REQUIRED_PERIOD_IN_UKRAINE
                && candidate.isAllowedToVote();
    }

    private int getPeriodInUkraine(String period) {
        String[] periods = period.split(DEFIES);
        return Integer.valueOf(periods[TO_YEAR_INDEX]) - Integer.valueOf(periods[FROM_YEAR_INDEX]);
    }
}
