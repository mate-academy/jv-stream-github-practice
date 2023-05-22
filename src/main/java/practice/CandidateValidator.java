package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String PROPER_NATIONALITY = "Ukrainian";
    public static final String DELIMITER = "-";
    public static final int MIN_AGE = 35;
    public static final int MIN_LIVING_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(PROPER_NATIONALITY)
                && candidate.isAllowedToVote()
                && calculatePeriodInUkr(candidate.getPeriodsInUkr())
                >= MIN_LIVING_PERIOD_IN_UKRAINE;
    }

    private int calculatePeriodInUkr(String period) {
        String[] firstAndLastYear = period.split(DELIMITER);
        return Integer.parseInt(firstAndLastYear[1]) - Integer.parseInt(firstAndLastYear[0]);
    }
}
