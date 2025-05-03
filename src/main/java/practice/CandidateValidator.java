package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String YEARS_SEPARATOR = "-";
    private static final int MIN_REQUIRED_AGE = 35;
    private static final int REQUIRED_TIME_IN_COUNTRY = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final boolean IS_ALLOWED_TO_VOTE = true;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkr = candidate.getPeriodsInUkr().split(YEARS_SEPARATOR);
        int firstYearInCountry = Integer.parseInt(yearsInUkr[0]);
        int lastYearInCountry = Integer.parseInt(yearsInUkr[1]);
        int currentPeriodInCountry = lastYearInCountry - firstYearInCountry;
        return candidate.getAge() >= MIN_REQUIRED_AGE
                && candidate.isAllowedToVote() == IS_ALLOWED_TO_VOTE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && currentPeriodInCountry >= REQUIRED_TIME_IN_COUNTRY;
    }
}
