package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";
    private static final int YEARS_IN_UKRAINE = 10;
    private static final int START_PERIOD = 0;
    private static final int END_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && isLivesOverTenYears(candidate.getPeriodsInUkr());
    }

    private boolean isLivesOverTenYears(String stringPeriod) {
        String[] period = stringPeriod.split(SEPARATOR);
        return Integer.parseInt(period[END_PERIOD])
                - Integer.parseInt(period[START_PERIOD]) >= YEARS_IN_UKRAINE;
    }
}
